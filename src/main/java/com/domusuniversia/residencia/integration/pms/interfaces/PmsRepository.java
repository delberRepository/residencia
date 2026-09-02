package com.domusuniversia.residencia.integration.pms.interfaces;

import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityResponse;

public interface PmsRepository {
    PmsAvailabilityResponse getAvailability(PmsAvailabilityRequest request);
}