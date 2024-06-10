package demo.delivery_project.place.application.domain.service;

import demo.delivery_project.place.application.domain.mapper.PlaceRestMapper;
import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.usecase.in.GetPlaceUseCase;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPlaceService implements GetPlaceUseCase {
    private final GetPlaceOutPort getPlaceOutPort;
    private final PlaceRestMapper placeRestMapper;

    @Override
    public PlaceResponse get(UUID id) {
        Place place = getPlaceOutPort.get(id);
        return placeRestMapper.mapToResponse(place);
    }

    @Override
    public Page<PlaceResponse> getAll(Pageable pageable) {
        Page<Place> all = getPlaceOutPort.getAll(pageable);
        List<PlaceResponse> places = placeRestMapper.mapToResponse(all.getContent());
        return new PageImpl<>(places, pageable, all.getTotalElements());
    }

    @Override
    public List<PlaceResponse> getRegionPlaces(UUID regionId) {
        List<Place> places = getPlaceOutPort.getByRegionId(regionId);
        return placeRestMapper.mapToResponse(places);
    }
}
