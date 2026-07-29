package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.model.Residence;
import com.domusuniversia.residencia.repository.ResidenceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenceService {

    private final ResidenceRepository residenceRepository;

    public ResidenceService(ResidenceRepository residenceRepository) {
        this.residenceRepository = residenceRepository;
    }

    public List<Residence> findAll() {
        return residenceRepository.findAll();
    }

    public Residence findById(Long id) {
        return residenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Residence not found with id: " + id));
    }

    public Residence create(Residence residence) {
        residence.setId(null);
        return residenceRepository.save(residence);
    }

    public Residence update(Long id, Residence residence) {
        Residence existingResidence = findById(id);
        existingResidence.setName(residence.getName());
        existingResidence.setAddress(residence.getAddress());
        existingResidence.setEmail(residence.getEmail());
        existingResidence.setPhone(residence.getPhone());
        existingResidence.setDescription(residence.getDescription());
        return residenceRepository.save(existingResidence);
    }

    public void delete(Long id) {
        Residence residence = findById(id);
        residenceRepository.delete(residence);
    }
}
