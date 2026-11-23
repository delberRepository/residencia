package com.domusuniversia.residencia.controller;

import com.domusuniversia.residencia.dto.PreSaveRequest;
import com.domusuniversia.residencia.service.PreSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pre-save")
@RequiredArgsConstructor
@CrossOrigin
public class PreSaveController {
    private final PreSaveService preSaveService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PreSaveRequest request) {
        preSaveService.create(request);
    }
}
