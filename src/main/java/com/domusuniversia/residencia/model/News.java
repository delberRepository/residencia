package com.domusuniversia.residencia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class News {
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
