package demo.delivery_project.place.application.domain.model;

import demo.delivery_project.region.application.domain.model.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    private UUID id = UUID.randomUUID();
    private String name;
    private Region region;
    private Boolean isDeleted = Boolean.FALSE;
}
