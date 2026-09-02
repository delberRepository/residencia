package com.domusuniversia.residencia.integration.pms.dto;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;

public class PmsReservationRequest {
    private RoomType roomType;
    private StayDuration stayDuration;
    private String name;
    private String email;
}
