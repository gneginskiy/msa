package com.otus.msa.service;

import com.otus.msa.model.dto.HealthDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthService {
    public HealthDto getCurrentHealthState() {
        return new HealthDto().setStatus(HealthDto.HealthStatus.OK);
    }
}
