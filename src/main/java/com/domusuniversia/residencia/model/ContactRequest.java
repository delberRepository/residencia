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
public class ContactRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String message;
    private Date createdAt;

    public ContactRequest(String name, String surname, String email, String phone, String message, Date createdAt) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.createdAt = createdAt;
    }
}
