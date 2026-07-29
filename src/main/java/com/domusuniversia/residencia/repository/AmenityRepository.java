package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
}
