package demo.delivery_project.place.application.usecase.out;

import demo.delivery_project.place.application.domain.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetPlaceOutPort {
    Place get(UUID id);

    List<Place> getByRegionId(UUID regionId);

    List<Place> getAllByIds(List<UUID> uuids);

    Boolean existsByName(String name);

    Page<Place> getAll(Pageable pageable);
}
