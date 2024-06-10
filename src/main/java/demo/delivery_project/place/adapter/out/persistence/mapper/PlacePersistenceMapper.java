package demo.delivery_project.place.adapter.out.persistence.mapper;

import demo.delivery_project.place.adapter.out.persistence.entity.PlaceJpaEntity;
import demo.delivery_project.place.application.domain.model.Place;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlacePersistenceMapper {
    PlaceJpaEntity mapToEntity(Place domain);

    List<PlaceJpaEntity> mapToEntity(List<Place> domains);

    Place mapToDomain(PlaceJpaEntity entity);

    List<Place> mapToDomain(List<PlaceJpaEntity> entities);
}
