package com.domusuniversia.residencia.dto;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PreSaveRequest {
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate entryDate;
    private String education;
    private StayDuration stayDuration;
    private RoomType roomType;
    private String email;
    private String phoneNumber;
    private boolean consent;
}
