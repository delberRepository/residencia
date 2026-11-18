package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRoom;
import com.domusuniversia.residencia.integration.pms.dto.PmsReservationRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsReservationResponse;
import com.domusuniversia.residencia.integration.pms.interfaces.PmsRepository;
import com.domusuniversia.residencia.model.Reservation;
import com.domusuniversia.residencia.model.ReservationStatus;
import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.model.StayDuration;
import com.domusuniversia.residencia.repository.ReservationRepository;
import com.domusuniversia.residencia.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final PmsRepository pmsRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    //este metodo tiene la logica de si hay conflicto y llama al metodo que contiene la logica de solapamiento
    private boolean hasConflict(
            Long roomId,
            StayDuration requestedDuration) {

        List<Reservation> reservations =
                reservationRepository.findByRoomId(roomId);

        return reservations.stream()
                .anyMatch(reservation ->
                        isOverlapping(
                                reservation.getStayDuration(),
                                requestedDuration
                        )
                );
    }
    //este metodo esta ideado para evaluar si hay solapamiento
    //y devuelve true si la hay
    private boolean isOverlapping(
            StayDuration existing,
            StayDuration requested) {

        if (existing == StayDuration.FULL_YEAR
                || existing == StayDuration.ACADEMIC_COURSE) {
            return true;
        }

        if (requested == StayDuration.FULL_YEAR
                || requested == StayDuration.ACADEMIC_COURSE) {
            return true;
        }

        return existing == requested; //retorna true si coincide la comparacion
    }

    public PmsReservationResponse createReservation(PmsReservationRequest request) {
       //Llamo al metodos del repo para comprobar duplicidad
        if (hasConflict(
                request.getRoomId(),
                request.getStayDuration())) {

            throw new IllegalStateException(
                    "La habitación ya está reservada para ese periodo"
            );
        }

        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow();
        //Busca en nuestra base de datos la habitación cuyo ID me ha enviado el usuario.
        //Si no existe, no puedo continuar.
        if (!room.getAvailable()) {
            throw new IllegalStateException(
                    "La habitación no está disponible"
            );
        }
        //Aqui creo un objeto de reservaRespuesta y dentro llamo al metodo crearReserva
        //luego mando un mensaje de error si el estado es diferente de confirmado
        PmsReservationResponse pmsResponse = pmsRepository.createReservation(request);
        if(pmsResponse.getStatus()!= ReservationStatus.CONFIRMED){
            throw new IllegalStateException(
                    "La reserva no ha sido confirmada por el PMS"
            );
        }


        //Ahora le voy pasando los datos a la entidad reserva y guardamos en la base de datos de la app
        Reservation reservation = new Reservation();
        reservation.setRoomId(room.getId());
        reservation.setRoomType(request.getRoomType());
        reservation.setStayDuration(request.getStayDuration());
        reservation.setName(request.getName());
        reservation.setEmail(request.getEmail());

        reservationRepository.save(reservation);


        return pmsResponse;

    }


}
