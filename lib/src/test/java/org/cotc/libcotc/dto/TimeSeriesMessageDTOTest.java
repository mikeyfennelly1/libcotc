package org.cotc.libcotc.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TimeSeriesMessageDTOTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void getBytesProducesValidJson() throws Exception {
        TimeSeriesMessageDTO dto = new TimeSeriesMessageDTO(
                UUID.randomUUID(),
                "sensor-1",
                1741305600000L,
                Map.of("temperature", 22.5, "humidity", 60.0)
        );

        byte[] bytes = dto.getBytes();
        assertNotNull(bytes);
        assertTrue(bytes.length > 0);

        // Deserialize back and check round-trip
        TimeSeriesMessageDTO deserialized = mapper.readValue(bytes, TimeSeriesMessageDTO.class);
        assertEquals("sensor-1", deserialized.getProducerName());
        assertEquals(1741305600000L, deserialized.getReadTime());
        assertEquals(22.5, deserialized.getValues().get("temperature"));
        assertEquals(60.0, deserialized.getValues().get("humidity"));
    }

    @Test
    void getBytesUsesSnakeCaseJsonKeys() throws Exception {
        TimeSeriesMessageDTO dto = new TimeSeriesMessageDTO(
                UUID.randomUUID(),
                "producer-a",
                1000L,
                Map.of("voltage", 3.3)
        );

        String json = new String(dto.getBytes());
        assertTrue(json.contains("\"producer_name\""), "Expected snake_case key 'producer_name'");
        assertTrue(json.contains("\"read_time\""), "Expected snake_case key 'read_time'");
        assertTrue(json.contains("\"values\""), "Expected key 'values'");
    }

    @Test
    void getBytesWithEmptyValues() throws Exception {
        TimeSeriesMessageDTO dto = new TimeSeriesMessageDTO(
                UUID.randomUUID(),
                "empty-producer",
                0L,
                Map.of()
        );

        byte[] bytes = dto.getBytes();
        assertNotNull(bytes);

        TimeSeriesMessageDTO deserialized = mapper.readValue(bytes, TimeSeriesMessageDTO.class);
        assertEquals("empty-producer", deserialized.getProducerName());
        assertEquals(0L, deserialized.getReadTime());
        assertTrue(deserialized.getValues().isEmpty());
    }

    @Test
    void getBytesWithMultipleMetrics() throws Exception {
        Map<String, Double> metrics = Map.of(
                "cpu", 78.4,
                "mem", 51.2,
                "disk", 33.0,
                "net_in", 1024.0,
                "net_out", 512.5
        );
        TimeSeriesMessageDTO dto = new TimeSeriesMessageDTO(
                UUID.randomUUID(),
                "server-1",
                9999999L,
                metrics
        );

        byte[] bytes = dto.getBytes();
        TimeSeriesMessageDTO deserialized = mapper.readValue(bytes, TimeSeriesMessageDTO.class);

        assertEquals(5, deserialized.getValues().size());
        assertEquals(78.4, deserialized.getValues().get("cpu"));
        assertEquals(1024.0, deserialized.getValues().get("net_in"));
    }

    @Test
    void noArgsConstructorAndSetters() throws Exception {
        TimeSeriesMessageDTO dto = new TimeSeriesMessageDTO();
        dto.setProducerName("manual-producer");
        dto.setReadTime(42L);
        dto.setValues(Map.of("x", 1.0));

        byte[] bytes = dto.getBytes();
        TimeSeriesMessageDTO deserialized = mapper.readValue(bytes, TimeSeriesMessageDTO.class);

        assertEquals("manual-producer", deserialized.getProducerName());
        assertEquals(42L, deserialized.getReadTime());
        assertEquals(1.0, deserialized.getValues().get("x"));
    }

    @Test
    void deserializeFromJsonString() throws Exception {
        String json = "{\"producer_name\":\"ext-source\",\"read_time\":1234567890,\"values\":{\"pressure\":101.3}}";

        TimeSeriesMessageDTO dto = mapper.readValue(json, TimeSeriesMessageDTO.class);

        assertEquals("ext-source", dto.getProducerName());
        assertEquals(1234567890L, dto.getReadTime());
        assertEquals(101.3, dto.getValues().get("pressure"));
    }
}
