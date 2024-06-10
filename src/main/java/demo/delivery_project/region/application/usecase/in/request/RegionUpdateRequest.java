package demo.delivery_project.region.application.usecase.in.request;

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
public class RegionUpdateRequest {
    private String name;
    private List<UUID> placeIds;
}
