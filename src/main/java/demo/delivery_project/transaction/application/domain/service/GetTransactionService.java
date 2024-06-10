package demo.delivery_project.transaction.application.domain.service;

import demo.delivery_project.transaction.application.domain.mapper.TransactionRestMapper;
import demo.delivery_project.transaction.application.domain.model.Transaction;
import demo.delivery_project.transaction.application.usecase.in.GetTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.response.DeliveryRegionsPerTransactionCount;
import demo.delivery_project.transaction.application.usecase.in.response.TotalTransactionScorePerCarrier;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionCountPerProduct;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import demo.delivery_project.transaction.application.usecase.out.GetTransactionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetTransactionService implements GetTransactionUseCase {
    private final GetTransactionOutPort getTransactionOutPort;
    private final TransactionRestMapper transactionRestMapper;

    @Override
    public TransactionResponse get(UUID id) {
        return transactionRestMapper.mapToResponse(getTransactionOutPort.get(id));
    }

    @Override
    public List<TransactionResponse> getAllByOwner(UUID ownerId, Pageable pageable) {
        List<Transaction> all = getTransactionOutPort.getAllByOwner(ownerId, pageable);
        return transactionRestMapper.mapToResponse(all);
    }

    @Override
    public List<DeliveryRegionsPerTransactionCount> getTransactionCountPerRegion() {
        return getTransactionOutPort.getTransactionCountPerRegion();
    }

    @Override
    public List<TotalTransactionScorePerCarrier> getTotalTransactionScorePerCarrier(Integer minScore) {
        return getTransactionOutPort.getTotalTransactionScorePerCarrier(minScore);
    }

    @Override
    public List<TransactionCountPerProduct> getTransactionCountPerProduct() {
        return getTransactionOutPort.getTransactionCountPerProduct();
    }

    @Override
    public List<TransactionResponse> getAllByRequestCode(String requestCode) {
        List<Transaction> transactions = getTransactionOutPort.getAllByRequestCode(requestCode);
        return transactionRestMapper.mapToResponse(transactions);
    }
}
