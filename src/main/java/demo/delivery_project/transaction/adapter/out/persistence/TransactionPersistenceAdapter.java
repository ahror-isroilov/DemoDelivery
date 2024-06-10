package demo.delivery_project.transaction.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.transaction.adapter.out.persistence.entity.TransactionJpaEntity;
import demo.delivery_project.transaction.adapter.out.persistence.mapper.TransactionPersistenceMapper;
import demo.delivery_project.transaction.adapter.out.persistence.repository.TransactionJooqRepository;
import demo.delivery_project.transaction.adapter.out.persistence.repository.TransactionJpaRepository;
import demo.delivery_project.transaction.application.domain.model.Transaction;
import demo.delivery_project.transaction.application.usecase.in.response.DeliveryRegionsPerTransactionCount;
import demo.delivery_project.transaction.application.usecase.in.response.TotalTransactionScorePerCarrier;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionCountPerProduct;
import demo.delivery_project.transaction.application.usecase.out.DeleteTransactionOutPort;
import demo.delivery_project.transaction.application.usecase.out.GetTransactionOutPort;
import demo.delivery_project.transaction.application.usecase.out.SaveTransactionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionPersistenceAdapter implements DeleteTransactionOutPort, GetTransactionOutPort, SaveTransactionOutPort {
    private final TransactionPersistenceMapper transactionPersistenceMapper;
    private final TransactionJpaRepository transactionJpaRepository;
    private final TransactionJooqRepository transactionJooqRepository;

    @Override
    public Transaction save(Transaction domain) {
        TransactionJpaEntity entity = transactionJpaRepository.save(transactionPersistenceMapper.mapToEntity(domain));
        return transactionPersistenceMapper.mapToDomain(entity);
    }

    @Override
    public Transaction get(UUID id) {
        TransactionJpaEntity entity = transactionJpaRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException(ErrorMessages.TRANSACTION_NOT_FOUND)
        );
        return transactionPersistenceMapper.mapToDomain(entity);
    }

    @Override
    public List<Transaction> getAllByRequestCode(String requestCode) {
        List<TransactionJpaEntity> entity = transactionJpaRepository.findAllByRequestCode(requestCode);
        return transactionPersistenceMapper.mapToDomain(entity);
    }

    @Override
    public List<Transaction> getAllByOwner(UUID ownerId, Pageable pageable) {
        Page<TransactionJpaEntity> all = transactionJpaRepository.getAllByCreatedBy(ownerId, pageable);
        return transactionPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public Boolean existsById(UUID id) {
        return transactionJpaRepository.existsById(id);
    }

    @Override
    public Boolean existsByCode(String code) {
        return transactionJpaRepository.existsByCode(code);
    }

    @Override
    public List<DeliveryRegionsPerTransactionCount> getTransactionCountPerRegion() {
        return transactionJooqRepository.getTransactionCountPerRegion();
    }

    @Override
    public List<TotalTransactionScorePerCarrier> getTotalTransactionScorePerCarrier(Integer minScore) {
        return transactionJooqRepository.getTotalTransactionScorePerCarrier(minScore);
    }

    @Override
    public List<TransactionCountPerProduct> getTransactionCountPerProduct() {
        return transactionJooqRepository.getTransactionCountPerProduct();
    }

    @Override
    public Boolean existsByOfferAndRequestCode(String offerCode, String requestCode) {
        return transactionJpaRepository.existsByRequestCodeAndOfferCode(requestCode, offerCode);
    }

    @Override
    public Boolean checkIfPlacesInCarrierServiceRegion(String carrierName, String offerPlaceName, String requestPlaceName) {
        return transactionJooqRepository.checkIfTwoPlacesHaveSameRegion(carrierName, requestPlaceName, offerPlaceName);
    }

    @Override
    public void delete(UUID id) {
        transactionJpaRepository.deleteById(id);
    }
}
