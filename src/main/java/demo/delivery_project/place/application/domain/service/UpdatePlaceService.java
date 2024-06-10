package demo.delivery_project.place.application.domain.service;

import demo.delivery_project.place.adapter.out.persistence.mapper.PlacePersistenceMapper;
import demo.delivery_project.place.application.domain.mapper.PlaceRestMapper;
import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.usecase.in.UpdatePlaceUseCase;
import demo.delivery_project.place.application.usecase.in.request.PlaceUpdateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.place.application.usecase.out.UpdatePlaceOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdatePlaceService implements UpdatePlaceUseCase {
    private final UpdatePlaceOutPort updatePlaceOutPort;
    private final GetPlaceOutPort getPlaceOutPort;
    private final PlaceRestMapper placeRestMapper;

    @Override
    public PlaceResponse update(UUID id, PlaceUpdateRequest request) {
        Place place = getPlaceOutPort.get(id);
        placeRestMapper.mapToDomain(request, place);
        return placeRestMapper.mapToResponse(updatePlaceOutPort.update(place));
    }
}
