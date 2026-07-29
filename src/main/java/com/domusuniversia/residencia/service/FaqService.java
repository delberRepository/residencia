package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.model.FAQ;
import com.domusuniversia.residencia.repository.FAQRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    private final FAQRepository faqRepository;

    public FaqService(FAQRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public List<FAQ> findAll() {
        return faqRepository.findAllByOrderByOrderAsc();
    }

    public FAQ findById(Long id) {
        return faqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("FAQ not found with id: " + id));
    }

    public FAQ create(FAQ faq) {
        faq.setId(null);
        return faqRepository.save(faq);
    }

    public FAQ update(Long id, FAQ faq) {
        FAQ existingFaq = findById(id);
        existingFaq.setQuestion(faq.getQuestion());
        existingFaq.setAnswer(faq.getAnswer());
        existingFaq.setOrder(faq.getOrder());
        return faqRepository.save(existingFaq);
    }

    public void delete(Long id) {
        FAQ faq = findById(id);
        faqRepository.delete(faq);
    }
}
