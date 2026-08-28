package com.domusuniversia.residencia.integration.pms.model;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;

import java.math.BigDecimal;

public class PmsAvailabilityRoom {
    private String id;

    private RoomType roomType;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    //datos de la habitacion disponible, luego uso un array para devolver todas desde PmsAvalabilityResponse
}
