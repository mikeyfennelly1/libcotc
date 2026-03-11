package org.cotc.libcotc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSeriesMessageDTO {

    @JsonProperty("producer_id")
    private UUID producerId;

    @JsonProperty("producer_name")
    private String producerName;

    @JsonProperty("read_time")
    private long readTime;

    @JsonProperty("values")
    private Map<String, Double> values;

    @JsonIgnore
    public byte[] getBytes() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(this);
    }
}
