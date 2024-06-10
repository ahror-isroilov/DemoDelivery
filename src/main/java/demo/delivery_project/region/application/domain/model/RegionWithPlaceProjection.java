package demo.delivery_project.region.application.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import demo.delivery_project.place.application.domain.model.PlaceProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionWithPlaceProjection {
    @JsonProperty(namespace = "id")
    private UUID id;

    @JsonProperty(namespace = "name")
    private String name;

    @JsonProperty(namespace = "places")
    private List<PlaceProjection> places;
}
