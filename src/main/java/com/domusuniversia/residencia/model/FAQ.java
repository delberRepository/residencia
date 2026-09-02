package com.domusuniversia.residencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FAQ {

    @Id
    @GeneratedValue
    private Long id;
    private String question;
    private String answer;
    @Column(name = "display_order")
    private Integer order;

    public FAQ(String question, String answer, Integer order) {
        this.question = question;
        this.answer = answer;
        this.order = order;
    }
}
