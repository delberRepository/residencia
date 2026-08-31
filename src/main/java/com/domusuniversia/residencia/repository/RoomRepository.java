package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.Room;
import com.domusuniversia.residencia.model.RoomType;
import com.domusuniversia.residencia.model.StayDuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailable(Boolean available);

    List<Room> findByTipo(RoomType tipo);
    List<Room> findByTipoAndAvailableAndStayDuration(
            RoomType tipo,
            Boolean available,
            StayDuration stayDuration
    );
}
