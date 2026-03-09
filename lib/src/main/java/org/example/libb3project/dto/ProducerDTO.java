package org.example.libb3project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class ProducerDTO {
    private UUID uuid;
    private String producerName;
    private String streamName;
}
