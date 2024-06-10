package demo.delivery_project.region.application.usecase.in;

import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetRegionUseCase {
    RegionResponse get(UUID id);

    Page<RegionResponse> getAll(Pageable pageable);

    List<RegionWithPlaceProjection> getRegionsWithPlaces();

}
