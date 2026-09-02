package com.domusuniversia.residencia.integration.pms.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PmsAvailabilityRoom {
        private String pmsRoomId;
        private Long roomId;
        private BigDecimal price;
        private String description;
        private String number;



    //datos de la habitacion disponible, luego uso un array para devolver todas desde PmsAvalabilityResponse
}
