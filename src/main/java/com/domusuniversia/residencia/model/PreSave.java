package com.domusuniversia.residencia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PreSave {

        @Id
        @GeneratedValue
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthDate;
       /* private LocalDate entryDate;*/
        private String education;
        @Enumerated(EnumType.STRING)
        private StayDuration stayDuration;
        @Enumerated(EnumType.STRING)
        private RoomType roomType;
        private String email;
        private String phoneNumber;
        private boolean consent;




}
