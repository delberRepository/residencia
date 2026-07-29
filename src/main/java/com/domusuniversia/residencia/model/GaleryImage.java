package com.domusuniversia.residencia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GaleryImage {
    @Id
    @GeneratedValue
    private Long id;

    private String url;
    private String title;
    private String imageOrder;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public GaleryImage(String url, String title, String imageOrder, Room room) {
        this.url = url;
        this.title = title;
        this.imageOrder = imageOrder;
        this.room = room;
    }
}
