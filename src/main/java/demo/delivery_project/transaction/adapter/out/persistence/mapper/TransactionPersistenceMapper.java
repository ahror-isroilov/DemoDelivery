package demo.delivery_project.transaction.adapter.out.persistence.mapper;

import demo.delivery_project.transaction.adapter.out.persistence.entity.TransactionJpaEntity;
import demo.delivery_project.transaction.application.domain.model.Transaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionPersistenceMapper {
    Transaction mapToDomain(TransactionJpaEntity entity);

    List<Transaction> mapToDomain(List<TransactionJpaEntity> entities);

    TransactionJpaEntity mapToEntity(Transaction domain);

    List<TransactionJpaEntity> mapToEntity(List<Transaction> domains);
}
