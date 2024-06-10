package demo.delivery_project.transaction.application.usecase.out;

import java.util.UUID;

public interface DeleteTransactionOutPort {
    void delete(UUID id);
}
