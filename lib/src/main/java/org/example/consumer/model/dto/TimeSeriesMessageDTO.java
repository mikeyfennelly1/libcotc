package org.example.consumer.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.consumer.model.dto.ProducerDTO;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSeriesMessageDTO {

    @JsonProperty("read_time")
    private long readTime;

    @NotEmpty
    @JsonProperty("values")
    private Map<String, Double> values;

    @NotNull
    @Valid
    @JsonProperty("source_properties")
    private ProducerDTO producer;
}
