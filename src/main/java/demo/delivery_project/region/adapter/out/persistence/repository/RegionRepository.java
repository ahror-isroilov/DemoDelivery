package demo.delivery_project.region.adapter.out.persistence.repository;

import demo.delivery_project.region.adapter.out.persistence.entity.RegionJpaEntity;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RegionRepository extends JpaRepository<RegionJpaEntity, UUID> {
    Boolean existsByName(String name);
}
