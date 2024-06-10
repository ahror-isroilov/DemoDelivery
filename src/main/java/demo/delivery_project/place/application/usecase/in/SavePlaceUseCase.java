package demo.delivery_project.place.application.usecase.in;

import demo.delivery_project.place.application.usecase.in.request.PlaceCreateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponseWithPlaces;

public interface SavePlaceUseCase {
    PlaceResponse save(PlaceCreateRequest request);
}
