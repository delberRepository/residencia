package com.domusuniversia.residencia.model;

import jakarta.persistence.*;
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
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private String numero;
    private String floor;
    private String description;
    private String capacity;
    private Boolean available;

    @Enumerated(EnumType.STRING)
    private StayDuration stayDuration;

    @Enumerated(EnumType.STRING)
    private RoomType tipo;

    @ManyToMany
    @JoinTable(
            name = "room_amenity",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenity> amenities = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GaleryImage> galleryImages = new ArrayList<>();

    public Room(String numero, String floor, String description, String capacity, Boolean available, RoomType tipo) {
        this.numero = numero;
        this.floor = floor;
        this.description = description;
        this.capacity = capacity;
        this.available = available;
        this.tipo = tipo;
        
    }
}
