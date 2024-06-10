package demo.delivery_project.transaction.adapter.in.web;

import demo.delivery_project.transaction.adapter.in.web.contract.UserTransactionController;
import demo.delivery_project.transaction.application.usecase.in.EvaluateTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.GetTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserTransactionControllerImpl implements UserTransactionController {
    private final EvaluateTransactionUseCase evaluateTransactionUseCase;
    private final GetTransactionUseCase getTransactionUseCase;

    @Override
    public ResponseEntity<HashMap<String, Boolean>> evaluate(UUID id, Byte score) {
        return new ResponseEntity<>(new HashMap<>() {{
            put("success", evaluateTransactionUseCase.evaluate(id, score));
        }}, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TransactionResponse>> getAllByRequestCode(String requestCode) {
        return new ResponseEntity<>(
                getTransactionUseCase.getAllByRequestCode(requestCode),
                HttpStatus.OK);
    }
}
