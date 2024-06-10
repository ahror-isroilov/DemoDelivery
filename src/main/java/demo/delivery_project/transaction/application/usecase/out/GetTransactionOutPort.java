package demo.delivery_project.transaction.application.usecase.out;

import demo.delivery_project.transaction.application.domain.model.Transaction;
import demo.delivery_project.transaction.application.usecase.in.response.DeliveryRegionsPerTransactionCount;
import demo.delivery_project.transaction.application.usecase.in.response.TotalTransactionScorePerCarrier;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionCountPerProduct;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetTransactionOutPort {
    Transaction get(UUID id);

    List<Transaction> getAllByRequestCode(String requestCode);

    List<Transaction> getAllByOwner(UUID ownerId, Pageable pageable);

    Boolean existsById(UUID id);

    Boolean existsByCode(String code);

    List<DeliveryRegionsPerTransactionCount> getTransactionCountPerRegion();

    List<TotalTransactionScorePerCarrier> getTotalTransactionScorePerCarrier(Integer minScore);

    List<TransactionCountPerProduct> getTransactionCountPerProduct();

    Boolean existsByOfferAndRequestCode(String offerCode, String requestCode);

    Boolean checkIfPlacesInCarrierServiceRegion(String carrierName, String offerPlaceName, String requestPlaceName);
}
