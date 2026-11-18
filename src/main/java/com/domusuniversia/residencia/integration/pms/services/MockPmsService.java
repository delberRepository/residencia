package com.domusuniversia.residencia.integration.pms.services;
import com.domusuniversia.residencia.integration.pms.dto.*;
import com.domusuniversia.residencia.integration.pms.interfaces.PmsRepository;
import com.domusuniversia.residencia.model.Reservation;
import com.domusuniversia.residencia.model.ReservationStatus;
import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.repository.ReservationRepository;
import com.domusuniversia.residencia.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@RequiredArgsConstructor
@Service
public class MockPmsService implements PmsRepository {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Override
    public PmsAvailabilityResponse getAvailability(PmsAvailabilityRequest request) {

        List<Room> rooms = roomRepository.findByTipoAndAvailableAndStayDuration(
                request.getRoomType(),
                true,
                request.getStayDuration()
        );
        //aqui se pasa el parametro de la peticion del usuario, que es tipo de habitacion,
        // la duracion de la estancia,
        // y habitacion disponible que se traduce como true
        //de esta manera solo se creara una lista con las habitaciones disponibles y del tipo seleccionado
        //por el usuario

        //aqui el mockPms actua para generar una lista de habitaciones hasta que tengamos las PMS reales y genera una lista de habitaciones
        // disponibles  para la PmsAvailibilityResponse
        List<PmsAvailabilityRoom> availableRooms = rooms.stream()
                .map(room -> {
                    PmsAvailabilityRoom availableRoom = new PmsAvailabilityRoom();
                    //aqui voy a ir añadiendo propiedades
                    availableRoom.setRoomId(room.getId());
                    availableRoom.setDescription(room.getDescription());
                    availableRoom.setNumber(room.getNumero());
                    availableRoom.setPmsRoomId("MOCK-" + room.getId());
                    availableRoom.setPrice(BigDecimal.valueOf(5000));

                    return availableRoom;
                })
                .toList();

        return new PmsAvailabilityResponse(

                availableRooms,
                request.getStayDuration(),
                request.getRoomType()

                        );

    }
    @Override
    public PmsReservationResponse createReservation(
            PmsReservationRequest request) {

        PmsReservationResponse response = new PmsReservationResponse();

        response.setReservationId("MOCK-" + System.currentTimeMillis());
        response.setStatus(ReservationStatus.CONFIRMED);
        response.setRoomType(request.getRoomType());
        response.setStayDuration(request.getStayDuration());

        return response;
    }

    //el mock es como un tester temporal hasta que tengamos las PMS reales
}
