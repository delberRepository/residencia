package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FAQRepository extends JpaRepository<FAQ, Long> {
    List<FAQ> findAllByOrderByOrderAsc();
}
