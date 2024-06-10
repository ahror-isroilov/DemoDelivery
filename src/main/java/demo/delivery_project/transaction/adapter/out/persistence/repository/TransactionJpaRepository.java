package demo.delivery_project.transaction.adapter.out.persistence.repository;

import demo.delivery_project.transaction.adapter.out.persistence.entity.TransactionJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionJpaEntity, UUID> {
    List<TransactionJpaEntity> findAllByRequestCode(String requestCode);

    Boolean existsByRequestCodeAndOfferCode(String requestCode, String offerCode);

    Boolean existsByCode(String code);

    Page<TransactionJpaEntity> getAllByCreatedBy(UUID createdBy, Pageable pageable);

}
