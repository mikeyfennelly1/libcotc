package org.example.consumer.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StreamDTO {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Valid
    private List<StreamDTO> children;
    @NotNull
    @Valid
    private List<SourceDTO> sources;
}
