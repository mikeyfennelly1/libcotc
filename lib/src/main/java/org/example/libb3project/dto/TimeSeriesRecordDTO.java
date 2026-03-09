package org.example.libb3project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TimeSeriesRecordDTO {
    private UUID id;
    private String key;
    private float value;
    private String producerName;
    private Instant readTime;
}
