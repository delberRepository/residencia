package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}
