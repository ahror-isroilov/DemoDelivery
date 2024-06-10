package demo.delivery_project.transaction.application.usecase.in;

import demo.delivery_project.transaction.application.usecase.in.response.DeliveryRegionsPerTransactionCount;
import demo.delivery_project.transaction.application.usecase.in.response.TotalTransactionScorePerCarrier;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionCountPerProduct;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetTransactionUseCase {
    TransactionResponse get(UUID id);

    List<TransactionResponse> getAllByOwner(UUID ownerId, Pageable pageable);

    List<DeliveryRegionsPerTransactionCount> getTransactionCountPerRegion();

    List<TotalTransactionScorePerCarrier> getTotalTransactionScorePerCarrier(Integer minScore);

    List<TransactionCountPerProduct> getTransactionCountPerProduct();

    List<TransactionResponse> getAllByRequestCode(String requestCode);
}
