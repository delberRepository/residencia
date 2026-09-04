
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

    //este servicio usa los repos de pms y room implementados por cualquier servicio
    //este metodo es unico de este servicio no lo sobreescribe de nadie
    //Propiedades
    private final PmsRepository pmsRepository;
    private final RoomRepository roomRepository;


    //Metodos

    //Aqui creo un metodo que devuelva una lista del dto de habitaciones y le pasamos las peticiones
    //del servidor
    public List<AvailableRoomResponse> getAvailableRooms(
            PmsAvailabilityRequest request) {

        //creo un objeto dto de respuesta con disponibilidad de habitaciones en el PMS y para usar el metodo del repo
        //anteriormente creo un objeto PmsRepository, que entra en el objeto pmsResponse
        //llamo al metodo getAvailability() y le paso la petición con los parametros
        PmsAvailabilityResponse pmsResponse =
                pmsRepository.getAvailability(request);
        //importante el objeto PmsAvailabilityResponse contiene una lista de objetos PmsAvailabilityRoom en sus propiedades
        //por eso obtengo las habitaciones y las recorro con el metodo .map()

        return pmsResponse.getRooms().stream().map(this::buildAvailableRoomResponse).toList();
        //aqui le decimos por cada PmsAvailabilityRoom, llama a el método buildAvailableRoomResponse
        //abajo declaro el metodo que es donde hacemos la combinacion de datos del PMS
        //    +
        //datos de nuestra Room
    }


    private AvailableRoomResponse buildAvailableRoomResponse(
            PmsAvailabilityRoom pmsRoom) {

        Room room = roomRepository.findById(pmsRoom.getRoomId())
                .orElseThrow();
        //aqui creo el objeto
        AvailableRoomResponse response = new AvailableRoomResponse();

        //aqui le voy introduciendo los datos que obtengo de mi base de datos y del pms
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
