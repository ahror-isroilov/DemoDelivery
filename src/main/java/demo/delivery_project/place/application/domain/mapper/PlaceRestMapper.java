package demo.delivery_project.place.application.domain.mapper;

import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.usecase.in.request.PlaceCreateRequest;
import demo.delivery_project.place.application.usecase.in.request.PlaceUpdateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PlaceRestMapper {
    public abstract Place mapToDomain(PlaceCreateRequest request);

    public abstract PlaceResponse mapToResponse(Place domain);

    public abstract List<Place> mapToDomain(List<PlaceCreateRequest> requests);

    public abstract List<PlaceResponse> mapToResponse(List<Place> domains);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void mapToDomain(PlaceUpdateRequest request, @MappingTarget Place domain);
}
