package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.GaleryImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GaleryImageRepository extends JpaRepository<GaleryImage, Long> {
    List<GaleryImage> findByRoomId(Long roomId);
}
