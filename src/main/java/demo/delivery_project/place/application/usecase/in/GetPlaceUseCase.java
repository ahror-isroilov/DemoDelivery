package demo.delivery_project.place.application.usecase.in;

import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetPlaceUseCase {
    PlaceResponse get(UUID id);

    Page<PlaceResponse> getAll(Pageable pageable);

    List<PlaceResponse> getRegionPlaces(UUID regionId);

}
