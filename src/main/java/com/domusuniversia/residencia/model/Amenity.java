package com.domusuniversia.residencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Amenity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String icon;
    private String description;

    @ManyToMany(mappedBy = "amenities")
    private List<Room> rooms = new ArrayList<>();

    public Amenity(String name, String icon, String description) {
        this.name = name;
        this.icon = icon;
        this.description = description;
    }
}
