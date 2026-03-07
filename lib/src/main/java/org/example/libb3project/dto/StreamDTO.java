package org.example.libb3project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StreamDTO {
    private Long id;
    private String name;
    private List<StreamDTO> children;
    private List<SourceDTO> sources;
}
