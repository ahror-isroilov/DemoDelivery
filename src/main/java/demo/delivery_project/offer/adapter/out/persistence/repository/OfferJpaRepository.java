package demo.delivery_project.offer.adapter.out.persistence.repository;

import demo.delivery_project.offer.adapter.out.persistence.entity.OfferJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfferJpaRepository extends JpaRepository<OfferJpaEntity, UUID> {

    Page<OfferJpaEntity> findAllByCreatedBy(UUID createdBy, Pageable pageable);

    Boolean existsByCode(String code);

    Optional<OfferJpaEntity> getByCode(String code);
}
