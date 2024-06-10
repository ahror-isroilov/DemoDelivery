package demo.delivery_project.place.adapter.out.persistence.repository;

import demo.delivery_project.place.adapter.out.persistence.entity.PlaceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceJpaEntity, UUID> {

    List<PlaceJpaEntity> findAllByRegion_Id(UUID region_id);

    Boolean existsByName(String name);
}
