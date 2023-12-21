package com.otus.msa.controller;

import com.otus.msa.model.dto.HealthDto;
import com.otus.msa.service.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class HealthController {
    private final HealthService healthService;

    @GetMapping(path = {"/health/", "/health"}, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public HealthDto create() {
        return healthService.getCurrentHealthState();
    }
}
