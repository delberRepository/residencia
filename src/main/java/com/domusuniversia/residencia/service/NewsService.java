package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.model.News;
import com.domusuniversia.residencia.repository.NewsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> findAll() {
        return newsRepository.findAllByOrderByCreatedAtDesc();
    }

    public News findById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("News not found with id: " + id));
    }

    public News create(News news) {
        news.setId(null);
        if (news.getCreatedAt() == null) {
            news.setCreatedAt(new Date());
        }
        return newsRepository.save(news);
    }

    public News update(Long id, News news) {
        News existingNews = findById(id);
        existingNews.setTitle(news.getTitle());
        existingNews.setContent(news.getContent());
        existingNews.setImage(news.getImage());
        if (news.getCreatedAt() != null) {
            existingNews.setCreatedAt(news.getCreatedAt());
        }
        return newsRepository.save(existingNews);
    }

    public void delete(Long id) {
        News news = findById(id);
        newsRepository.delete(news);
    }
}
