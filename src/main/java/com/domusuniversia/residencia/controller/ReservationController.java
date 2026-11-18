package com.domusuniversia.residencia.controller;

import com.domusuniversia.residencia.dto.AvailableRoomResponse;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsReservationRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsReservationResponse;
import com.domusuniversia.residencia.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

   private final ReservationService reservationService;
    @PostMapping
    //aqui llamo al metodo del ReservationServices que no del MockPmsServices
    public PmsReservationResponse createReservation(@RequestBody PmsReservationRequest request)
    {

        return  reservationService.createReservation(request);
    }
}
