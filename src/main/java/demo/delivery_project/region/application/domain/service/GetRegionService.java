package demo.delivery_project.region.application.domain.service;

import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.region.application.domain.mapper.RegionRestMapper;
import demo.delivery_project.region.application.domain.model.Region;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.GetRegionUseCase;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.region.application.usecase.out.GetRegionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetRegionService implements GetRegionUseCase {
    private final GetRegionOutPort getRegionOutPort;
    private final RegionRestMapper regionRestMapper;

    @Override
    public RegionResponse get(UUID id) {
        Region region = getRegionOutPort.get(id);
        return regionRestMapper.mapToResponse(region);
    }

    @Override
    public Page<RegionResponse> getAll(Pageable pageable) {
        Page<Region> all = getRegionOutPort.getAll(pageable);
        List<RegionResponse> regions = regionRestMapper.mapToResponse(all.getContent());
        return new PageImpl<>(regions, pageable, all.getTotalElements());
    }

    @Override
    public List<RegionWithPlaceProjection> getRegionsWithPlaces() {
        return getRegionOutPort.getAllWithPlaces();
    }
}
