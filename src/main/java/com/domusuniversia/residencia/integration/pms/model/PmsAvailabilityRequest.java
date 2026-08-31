package com.domusuniversia.residencia.integration.pms.model;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PmsAvailabilityRequest {
    private StayDuration stayDuration;
    private int academicYear;
    private RoomType roomType;
    //año académico, porque necesitamos saber para qué periodo estamos consultando.
}
