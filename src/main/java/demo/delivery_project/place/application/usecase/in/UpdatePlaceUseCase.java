package demo.delivery_project.place.application.usecase.in;

import demo.delivery_project.place.application.usecase.in.request.PlaceUpdateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;

import java.util.UUID;

public interface UpdatePlaceUseCase {
    PlaceResponse update(UUID id, PlaceUpdateRequest request);
}
