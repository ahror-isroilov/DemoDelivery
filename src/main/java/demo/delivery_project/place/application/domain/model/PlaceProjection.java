package demo.delivery_project.place.application.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceProjection {
    @JsonProperty(namespace = "id")
    private UUID id;

    @JsonProperty(namespace = "name")
    private String name;
}
