package com.domusuniversia.residencia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FAQ {
    private Long id;
    private String question;
    private String answer;
    private Integer order;

    public FAQ(String question, String answer, Integer order) {
        this.question = question;
        this.answer = answer;
        this.order = order;
    }
}
