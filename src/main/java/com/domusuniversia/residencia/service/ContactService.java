package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.model.ContactRequest;
import com.domusuniversia.residencia.repository.ContactRequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContactService {

    private final ContactRequestRepository contactRequestRepository;

    public ContactService(ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    public List<ContactRequest> findAll() {
        return contactRequestRepository.findAllByOrderByCreatedAtDesc();
    }

    public ContactRequest findById(Long id) {
        return contactRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact request not found with id: " + id));
    }

    public ContactRequest create(ContactRequest contactRequest) {
        contactRequest.setId(null);
        if (contactRequest.getCreatedAt() == null) {
            contactRequest.setCreatedAt(new Date());
        }
        return contactRequestRepository.save(contactRequest);
    }

    public void delete(Long id) {
        ContactRequest contactRequest = findById(id);
        contactRequestRepository.delete(contactRequest);
    }
}
