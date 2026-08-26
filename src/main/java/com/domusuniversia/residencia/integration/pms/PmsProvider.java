package com.domusuniversia.residencia.integration.pms;

import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;

public interface PmsProvider {

    AvailabilityResponse checkAvailability(
            RoomType roomType,
            StayDuration stayDuration
    );

    ReservationResponse createReservation(
            ReservationRequest request
    );

    ReservationResponse getReservation(
            String reservationId
    );

    void cancelReservation(
            String reservationId
    );
}