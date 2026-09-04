package com.domusuniversia.residencia.controller;
import com.domusuniversia.residencia.dto.AvailableRoomResponse;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRequest;
import com.domusuniversia.residencia.service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
@RequiredArgsConstructor
public class AvailabilityController {

    private final AvailabilityService availabilityservice;

    @PostMapping
    public List<AvailableRoomResponse> getAvailableRooms(@RequestBody PmsAvailabilityRequest request)
    {
        return  availabilityservice.getAvailableRooms(request);
    }
}