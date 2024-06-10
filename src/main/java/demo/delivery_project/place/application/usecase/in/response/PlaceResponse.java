package demo.delivery_project.place.application.usecase.in.response;

import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponse {
    private UUID id;
    private String name;
    private RegionResponse region;
}
