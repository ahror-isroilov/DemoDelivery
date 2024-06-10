package demo.delivery_project.transaction.application.usecase.in;

import java.util.UUID;

public interface DeleteTransactionUseCase {
    void delete(UUID id);
}
