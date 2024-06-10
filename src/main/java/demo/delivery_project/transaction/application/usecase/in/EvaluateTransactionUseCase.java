package demo.delivery_project.transaction.application.usecase.in;

import java.util.UUID;

public interface EvaluateTransactionUseCase {
    Boolean evaluate(UUID id, Byte score);
}
