package com.domusuniversia.residencia.controller;

import com.domusuniversia.residencia.integration.pms.interfaces.PmsRepository;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/availability")
@RequiredArgsConstructor
public class AvailabilityController {

    private final PmsRepository pmsRepository;

    @PostMapping
    public PmsAvailabilityResponse getAvailability(
            @RequestBody PmsAvailabilityRequest request
    ) {
        return pmsRepository.getAvailability(request);
    }
}