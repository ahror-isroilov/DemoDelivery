package demo.delivery_project.product.adapter.out.persistence.repository;

import demo.delivery_project.product.adapter.out.persistence.entity.ProductJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpaEntity, UUID> {

    Boolean existsByCreatedByAndName(UUID createdBy, String name);

    Boolean existsByCreatedByAndCode(UUID createdBy, String code);

    Page<ProductJpaEntity> getAllByCreatedBy(UUID createdBy, Pageable pageable);
}
