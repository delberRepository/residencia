package com.domusuniversia.residencia.integration.pms.interfaces;

import com.domusuniversia.residencia.integration.pms.model.PmsAvailabilityRequest;
import com.domusuniversia.residencia.integration.pms.model.PmsAvailabilityResponse;

public interface PmsProvider {
    PmsAvailabilityResponse getAvailability(PmsAvailabilityRequest request);
}