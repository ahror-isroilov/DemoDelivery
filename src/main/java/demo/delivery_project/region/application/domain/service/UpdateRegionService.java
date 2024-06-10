package demo.delivery_project.region.application.domain.service;

import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.domain.model.PlaceProjection;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.place.application.usecase.out.SavePlaceOutPort;
import demo.delivery_project.region.application.domain.mapper.RegionRestMapper;
import demo.delivery_project.region.application.domain.model.Region;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.UpdateRegionUseCase;
import demo.delivery_project.region.application.usecase.in.request.RegionUpdateRequest;
import demo.delivery_project.region.application.usecase.out.GetRegionOutPort;
import demo.delivery_project.region.application.usecase.out.UpdateRegionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateRegionService implements UpdateRegionUseCase {
    private final UpdateRegionOutPort updateRegionOutPort;
    private final GetRegionOutPort getRegionOutPort;
    private final GetPlaceOutPort getPlaceOutPort;
    private final SavePlaceOutPort savePlaceOutPort;
    private final RegionRestMapper regionRestMapper;

    @Override
    public RegionWithPlaceProjection update(UUID id, RegionUpdateRequest request) {
        Region region = getRegionOutPort.get(id);
        regionRestMapper.mapToDomain(request, region);
        List<PlaceProjection> placesProjection = new ArrayList<>();
        if (request.getPlaceIds() != null && request.getPlaceIds().isEmpty()) {
            List<UUID> placeIds = request.getPlaceIds();
            List<Place> places = getPlaceOutPort.getAllByIds(placeIds);
            places.forEach(place -> {
                place.setRegion(region);
                placesProjection.add(new PlaceProjection(place.getId(), place.getName()));
            });
            savePlaceOutPort.saveAll(places);
        }
        Region updated = updateRegionOutPort.update(region);
        return new RegionWithPlaceProjection(
                updated.getId(),
                updated.getName(),
                placesProjection
        );
    }
}
