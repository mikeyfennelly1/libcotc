package org.cotc.libcotc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class GroupDTO {
    private UUID uuid;
    private String name;
    private List<GroupDTO> children;
    private List<ProducerDTO> producers;
}
