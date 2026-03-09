package org.example.libb3project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class StreamDTO {
    private UUID uuid;
    private String name;
    private List<StreamDTO> children;
    private List<SourceDTO> sources;
}
