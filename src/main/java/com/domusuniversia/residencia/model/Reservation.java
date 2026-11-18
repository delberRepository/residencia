package com.domusuniversia.residencia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;
    private Long roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Enumerated(EnumType.STRING)
    private StayDuration stayDuration;
    private String name;
    private String email;

    public Reservation(Long roomId,RoomType roomType, StayDuration stayDuration, String name, String email) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.stayDuration = stayDuration;
        this.name = name;
        this.email = email;

    }

}
