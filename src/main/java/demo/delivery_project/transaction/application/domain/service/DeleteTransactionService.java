package demo.delivery_project.transaction.application.domain.service;

import demo.delivery_project.transaction.application.usecase.in.DeleteTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.out.DeleteTransactionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteTransactionService implements DeleteTransactionUseCase {
    private final DeleteTransactionOutPort deleteTransactionOutPort;

    @Override
    public void delete(UUID id) {
        deleteTransactionOutPort.delete(id);
    }
}
