package com.domusuniversia.residencia.integration.pms.model;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;

import java.util.List;

public class PmsAvalabilityResponse {
    private List<PmsAvailabilityRoom> rooms;
    private StayDuration stayDuration;
    private RoomType roomType;
}
