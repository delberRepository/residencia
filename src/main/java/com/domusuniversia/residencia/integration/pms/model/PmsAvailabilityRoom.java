package com.domusuniversia.residencia.integration.pms.model;

import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PmsAvailabilityRoom {
        private String pmsRoomId;
        private Long roomId;
        private BigDecimal price;


    //datos de la habitacion disponible, luego uso un array para devolver todas desde PmsAvalabilityResponse
}
