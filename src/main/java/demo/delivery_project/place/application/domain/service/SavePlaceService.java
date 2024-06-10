package demo.delivery_project.place.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.place.application.domain.mapper.PlaceRestMapper;
import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.usecase.in.SavePlaceUseCase;
import demo.delivery_project.place.application.usecase.in.request.PlaceCreateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import demo.delivery_project.place.application.usecase.out.SavePlaceOutPort;
import demo.delivery_project.region.application.usecase.out.GetRegionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePlaceService implements SavePlaceUseCase {
    private final SavePlaceOutPort savePlaceOutPort;
    private final PlaceRestMapper placeRestMapper;
    private final GetRegionOutPort getRegionOutPort;

    @Override
    public PlaceResponse save(PlaceCreateRequest request) {
        if (!getRegionOutPort.existsById(request.getRegionId()))
            throw new DataNotFoundException(ErrorMessages.REGION_NOT_FOUND);
        Place place = savePlaceOutPort.save(placeRestMapper.mapToDomain(request));
        return placeRestMapper.mapToResponse(place);
    }
}
