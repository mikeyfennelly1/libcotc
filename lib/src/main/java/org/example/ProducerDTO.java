package org.example.consumer.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProducerDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String producerName;
    @NotBlank
    private String streamName;
}
