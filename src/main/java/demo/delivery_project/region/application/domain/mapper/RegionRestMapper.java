package demo.delivery_project.region.application.domain.mapper;

import demo.delivery_project.place.application.domain.mapper.PlaceRestMapper;
import demo.delivery_project.region.application.domain.model.Region;
import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import demo.delivery_project.region.application.usecase.in.request.RegionUpdateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlaceRestMapper.class})
public abstract class RegionRestMapper {

    public abstract Region mapToDomain(RegionCreateRequest request);

    public abstract RegionResponse mapToResponse(Region domain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void mapToDomain(RegionUpdateRequest request, @MappingTarget Region domain);

    public abstract List<RegionResponse> mapToResponse(List<Region> domains);
}
