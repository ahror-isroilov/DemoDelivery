package demo.delivery_project.transaction.adapter.in.web;

import demo.delivery_project.transaction.adapter.in.web.contract.TransactionStatisticsController;
import demo.delivery_project.transaction.application.usecase.in.GetTransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class TransactionStatisticsControllerImpl implements TransactionStatisticsController {
    private final GetTransactionUseCase getTransactionUseCase;

    @Override
    public ResponseEntity<?> getTransactionCountPerRegion() {
        return new ResponseEntity<>(new HashMap<>() {{
            put("response", getTransactionUseCase.getTransactionCountPerRegion());
        }}, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getTotalTransactionScorePerCarrier(Integer minScore) {
        return new ResponseEntity<>(new HashMap<>() {{
            put("response", getTransactionUseCase.getTotalTransactionScorePerCarrier(minScore));
        }}, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getTransactionCountPerProduct() {
        return new ResponseEntity<>(new HashMap<>() {{
            put("response", getTransactionUseCase.getTransactionCountPerProduct());
        }}, HttpStatus.OK);
    }
}
