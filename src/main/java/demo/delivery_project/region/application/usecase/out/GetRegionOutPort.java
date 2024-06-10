package demo.delivery_project.region.application.usecase.out;

import demo.delivery_project.region.application.domain.model.Region;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.response.RegionResponseWithPlaces;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetRegionOutPort {
    Region get(UUID id);

    Boolean existsById(UUID id);

    Page<Region> getAll(Pageable pageable);

    List<RegionWithPlaceProjection> getAllWithPlaces();

}
