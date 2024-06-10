package demo.delivery_project.region.application.usecase.in;

import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.region.application.usecase.in.response.RegionResponseWithPlaces;

public interface SaveRegionUseCase {
    RegionResponse save(RegionCreateRequest request);
}
