package com.domusuniversia.residencia.service;

import com.domusuniversia.residencia.dto.PreSaveRequest;
import com.domusuniversia.residencia.model.PreSave;
import com.domusuniversia.residencia.repository.PreSaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
@RequiredArgsConstructor
public class PreSaveService {
    private final PreSaveRepository preSaveRepository;

    public PreSave create(PreSaveRequest request) {
        if (request.getName() == null || request.getName().isBlank()
                || request.getSurname() == null || request.getSurname().isBlank()
                || request.getBirthDate() == null
                /*|| request.getEntryDate() == null*/
                || request.getEducation() == null || request.getEducation().isBlank()
                || request.getStayDuration() == null || request.getRoomType() == null
                || request.getEmail() == null || request.getEmail().isBlank()
                || request.getPhoneNumber() == null || request.getPhoneNumber().isBlank()
                || !request.isConsent()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Completa todos los campos y acepta el consentimiento."
            );
        }

        PreSave preSave = new PreSave();
        preSave.setName(request.getName().trim());
        preSave.setSurname(request.getSurname().trim());
        preSave.setBirthDate(request.getBirthDate());
        /*preSave.setEntryDate(request.getEntryDate());*/
        preSave.setEducation(request.getEducation().trim());
        preSave.setStayDuration(request.getStayDuration());
        preSave.setRoomType(request.getRoomType());
        preSave.setEmail(request.getEmail().trim());
        preSave.setPhoneNumber(request.getPhoneNumber().trim());
        preSave.setConsent(request.isConsent());
        return preSaveRepository.save(preSave);
    }
}
