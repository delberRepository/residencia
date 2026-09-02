
package com.domusuniversia.residencia.service;
import com.domusuniversia.residencia.dto.AvailableRoomResponse;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRequest;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityResponse;
import com.domusuniversia.residencia.integration.pms.dto.PmsAvailabilityRoom;
import com.domusuniversia.residencia.integration.pms.interfaces.PmsRepository;
import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailabilityService {

    private final PmsRepository pmsRepository;
    private final RoomRepository roomRepository;

    public List<AvailableRoomResponse> getAvailableRooms(
            PmsAvailabilityRequest request) {

        PmsAvailabilityResponse pmsResponse =
                pmsRepository.getAvailability(request);

        return pmsResponse.getRooms()
                .stream()
                .map(this::buildAvailableRoomResponse)
                .toList();
    }

    private AvailableRoomResponse buildAvailableRoomResponse(
            PmsAvailabilityRoom pmsRoom) {

        Room room = roomRepository.findById(pmsRoom.getRoomId())
                .orElseThrow();

        AvailableRoomResponse response = new AvailableRoomResponse();

        response.setRoomId(room.getId());
        response.setPmsRoomId(pmsRoom.getPmsRoomId());
        response.setPrice(pmsRoom.getPrice());

        response.setNumero(room.getNumero());
        response.setFloor(room.getFloor());
        response.setDescription(room.getDescription());
        response.setCapacity(room.getCapacity());
        response.setAvailable(room.getAvailable());
        response.setTipo(room.getTipo());
        response.setStayDuration(room.getStayDuration());

        return response;
    }
}
