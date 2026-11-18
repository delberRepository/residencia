package com.domusuniversia.residencia.integration.pms.dto;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PmsReservationRequest {
    private RoomType roomType;
    private Long RoomId;
    private StayDuration stayDuration;
    private String name;
    private String email;
}
