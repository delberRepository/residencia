package com.domusuniversia.residencia.dto;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailableRoomResponse {
//plantilla para los datos de respuesta dto
    private Long roomId;
    private String pmsRoomId;
    private BigDecimal price;

    private String numero;
    private String floor;
    private String description;
    private String capacity;
    private Boolean available;

    private RoomType tipo;
    private StayDuration stayDuration;
}