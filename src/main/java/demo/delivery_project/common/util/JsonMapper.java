package demo.delivery_project.common.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class JsonMapper {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> T mapFromJson(String jsonString, Class<T> targetClass) {
        try {
            return OBJECT_MAPPER.readValue(jsonString, targetClass);
        } catch (Exception e) {
            throw new RuntimeException("Error mapping JSON to object", e);
        }
    }

    public static JsonNode mapFromJson(String jsonString) {
        try {
            return OBJECT_MAPPER.readTree(jsonString);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
}
