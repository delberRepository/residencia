package com.domusuniversia.residencia.integration.pms.interfaces;

import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityResponse;
import com.domusuniversia.residencia.integration.pms.dto.PmsReservationRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsReservationResponse;

public interface PmsRepository {
    PmsAvailabilityResponse getAvailability(PmsAvailabilityRequest request);
    PmsReservationResponse createReservation(PmsReservationRequest request);
}