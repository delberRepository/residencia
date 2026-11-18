package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.Reservation;
import com.domusuniversia.residencia.model.StayDuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    //este metodo del repo lo uso para saber si existe alguna reserva con ese id
   /*
   boolean existsByRoomIdAndStayDuration(
            Long roomId,
            StayDuration stayDuration
    );
    */
    List<Reservation> findByRoomId(Long roomId);

}
