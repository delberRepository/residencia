package com.domusuniversia.residencia.model;

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
public class Residence {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private String description;

    public Residence(String name, String address, String email, String phone, String description) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }
}
