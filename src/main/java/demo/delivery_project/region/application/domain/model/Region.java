package demo.delivery_project.region.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private UUID id = UUID.randomUUID();
    private String name;
    private Boolean isDeleted = Boolean.FALSE;
}
