package org.example.libb3project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProducerDTO {
    private Long id;
    private String producerName;
    private String streamName;
}
