package org.example.consumer.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class TimeSeriesRecordDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String key;
    private float value;
    @NotBlank
    private String producerName;
    @NotNull
    private Instant readTime;
}
