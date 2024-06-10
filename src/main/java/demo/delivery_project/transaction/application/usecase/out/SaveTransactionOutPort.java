package demo.delivery_project.transaction.application.usecase.out;

import demo.delivery_project.transaction.application.domain.model.Transaction;

public interface SaveTransactionOutPort {
    Transaction save(Transaction domain);
}
