package com.domusuniversia.residencia.integration.pms.dto;

import com.domusuniversia.residencia.model.ReservationStatus;
import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PmsReservationResponse {
    private String reservationId;
    private ReservationStatus status;
    private RoomType roomType;
    private StayDuration stayDuration;
}
