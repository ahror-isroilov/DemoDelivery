package demo.delivery_project.image.adapter.out.persistence.repository;

import demo.delivery_project.image.adapter.out.persistence.entity.ImageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageJpaRepository extends JpaRepository<ImageJpaEntity, UUID> {
}
