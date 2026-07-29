package com.domusuniversia.residencia.repository;

import com.domusuniversia.residencia.model.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
    List<ContactRequest> findAllByOrderByCreatedAtDesc();
}
