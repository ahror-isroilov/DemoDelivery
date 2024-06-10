package demo.delivery_project.region.adapter.out.persistence.mapper;

import demo.delivery_project.region.adapter.out.persistence.entity.RegionJpaEntity;
import demo.delivery_project.region.application.domain.model.Region;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionPersistenceMapper {
    RegionJpaEntity mapToEntity(Region domain);

    List<RegionJpaEntity> mapToEntity(List<Region> domains);

    Region mapToDomain(RegionJpaEntity entity);

    List<Region> mapToDomain(List<RegionJpaEntity> entities);
}
