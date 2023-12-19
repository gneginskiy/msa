package com.otus.msa.controller;

import com.otus.msa.model.HealthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(HealthController.HEALTH_API_URL)
@RequiredArgsConstructor
public class HealthController {
    public static final String HEALTH_API_URL = "/health/";

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public HealthDto create() {
        return new HealthDto().setStatus(HealthDto.HealthStatus.OK);
    }
}
