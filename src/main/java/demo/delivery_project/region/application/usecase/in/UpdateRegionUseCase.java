package demo.delivery_project.region.application.usecase.in;

import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.request.RegionUpdateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;

import java.util.UUID;

public interface UpdateRegionUseCase {
    RegionWithPlaceProjection update(UUID id, RegionUpdateRequest request);
}
