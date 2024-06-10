package demo.delivery_project.transaction.application.usecase.in;

import demo.delivery_project.transaction.application.usecase.in.request.TransactionCreateRequest;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;

public interface SaveTransactionUseCase {
    TransactionResponse save(TransactionCreateRequest request);
}
