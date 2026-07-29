package com.domusuniversia.residencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String image;
    private Date createdAt;

    public News(String title, String content, String image, Date createdAt) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
    }
}
