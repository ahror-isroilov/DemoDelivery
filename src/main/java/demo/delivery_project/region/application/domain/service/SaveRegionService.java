package demo.delivery_project.region.application.domain.service;

import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.place.application.domain.mapper.PlaceRestMapper;
import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.place.application.usecase.out.SavePlaceOutPort;
import demo.delivery_project.region.application.domain.mapper.RegionRestMapper;
import demo.delivery_project.region.application.domain.model.Region;
import demo.delivery_project.region.application.usecase.in.SaveRegionUseCase;
import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.region.application.usecase.out.SaveRegionOutPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveRegionService implements SaveRegionUseCase {
    private final SaveRegionOutPort saveRegionOutPort;
    private final RegionRestMapper regionRestMapper;
    private final PlaceRestMapper placeRestMapper;
    private final GetPlaceOutPort getPlaceOutPort;
    private final SavePlaceOutPort savePlaceOutPort;

    @Override
    @Transactional
    public RegionResponse save(RegionCreateRequest request) {
        Region reg = saveRegionOutPort.save(regionRestMapper.mapToDomain(request));
        List<Place> places = placeRestMapper.mapToDomain(request.getPlaces());
        places.forEach(p -> {
            if (getPlaceOutPort.existsByName(p.getName()))
                throw new NotAcceptableException(ErrorMessages.PLACE_ALREADY_EXISTS.formatted(p.getName()));
            p.setRegion(reg);
        });
        savePlaceOutPort.saveAll(places);
        return regionRestMapper.mapToResponse(reg);
    }
}
