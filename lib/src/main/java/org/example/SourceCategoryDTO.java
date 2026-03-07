package org.example.consumer.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceCategoryDTO {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotNull
    @Valid
    private List<SourceCategoryDTO> subcategories;
}
