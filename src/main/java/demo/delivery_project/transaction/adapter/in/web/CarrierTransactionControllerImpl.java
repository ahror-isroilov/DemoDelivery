package demo.delivery_project.transaction.adapter.in.web;

import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.transaction.adapter.in.web.contract.CarrierTransactionController;
import demo.delivery_project.transaction.application.usecase.in.DeleteTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.GetTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.SaveTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.request.TransactionCreateRequest;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CarrierTransactionControllerImpl implements CarrierTransactionController {
    private final SaveTransactionUseCase saveTransactionUseCase;
    private final GetTransactionUseCase getTransactionUseCase;
    private final DeleteTransactionUseCase deleteTransactionUseCase;

    @Override
    public ResponseEntity<TransactionResponse> save(TransactionCreateRequest request) {
        return new ResponseEntity<>(saveTransactionUseCase.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TransactionResponse> get(UUID id) {
        return new ResponseEntity<>(getTransactionUseCase.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TransactionResponse>> getAllByOwner(Integer page, Integer size) {
        return new ResponseEntity<>(getTransactionUseCase.getAllByOwner(
                SecurityUtils.getCurrentUserId(),
                PageRequest.of(page, size)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap<String, Boolean>> delete(UUID id) {
        deleteTransactionUseCase.delete(id);
        return new ResponseEntity<>(new HashMap<>() {{
            put("success", true);
        }}, HttpStatus.OK);
    }
}
