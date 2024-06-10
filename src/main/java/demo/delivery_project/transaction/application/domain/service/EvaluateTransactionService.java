package demo.delivery_project.transaction.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.transaction.application.domain.model.Transaction;
import demo.delivery_project.transaction.application.usecase.in.EvaluateTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.out.GetTransactionOutPort;
import demo.delivery_project.transaction.application.usecase.out.SaveTransactionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EvaluateTransactionService implements EvaluateTransactionUseCase {
    private final GetTransactionOutPort getTransactionOutPort;
    private final SaveTransactionOutPort saveTransactionOutPort;

    @Override
    public Boolean evaluate(UUID id, Byte score) {
        if (!getTransactionOutPort.existsById(id))
            throw new DataNotFoundException(ErrorMessages.TRANSACTION_NOT_FOUND);
        if (score < 1 || score > 10)
            return false;
        Transaction transaction = getTransactionOutPort.get(id);
        transaction.setScore(score);
        saveTransactionOutPort.save(transaction);
        return true;
    }
}
