package com.otus.msa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class HealthDto {
    public HealthStatus status;

    public enum HealthStatus {
        OK, NOT_OK
    }
}
