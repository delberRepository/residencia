package com.domusuniversia.residencia.integration.pms.model;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PmsAvailabilityResponse {
    private List<PmsAvailabilityRoom> rooms;
    private StayDuration stayDuration;
    private RoomType roomType;
}
