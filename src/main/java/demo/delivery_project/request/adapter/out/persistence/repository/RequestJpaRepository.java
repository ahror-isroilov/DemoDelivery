package demo.delivery_project.request.adapter.out.persistence.repository;

import demo.delivery_project.request.adapter.out.persistence.entity.RequestJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RequestJpaRepository extends JpaRepository<RequestJpaEntity, UUID> {

    Page<RequestJpaEntity> findAllByCreatedBy(UUID createdBy, Pageable pageable);

    Boolean existsByCode(String code);

    Optional<RequestJpaEntity> getByCode(String code);
}
