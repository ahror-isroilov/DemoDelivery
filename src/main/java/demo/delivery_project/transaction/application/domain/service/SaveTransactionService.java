package demo.delivery_project.transaction.application.domain.service;

import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.transaction.application.domain.mapper.TransactionRestMapper;
import demo.delivery_project.transaction.application.domain.model.Transaction;
import demo.delivery_project.transaction.application.usecase.in.SaveTransactionUseCase;
import demo.delivery_project.transaction.application.usecase.in.request.TransactionCreateRequest;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import demo.delivery_project.transaction.application.usecase.out.GetTransactionOutPort;
import demo.delivery_project.transaction.application.usecase.out.SaveTransactionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTransactionService implements SaveTransactionUseCase {
    private final SaveTransactionOutPort saveTransactionOutPort;
    private final GetTransactionOutPort getTransactionOutPort;
    private final TransactionRestMapper transactionRestMapper;

    @Override
    public TransactionResponse save(TransactionCreateRequest request) {
        Transaction domain = transactionRestMapper.mapToDomain(request);
        checkTransactionForCreation(domain);
        Transaction transaction = saveTransactionOutPort.save(domain);
        return transactionRestMapper.mapToResponse(transaction);
    }

    private void checkTransactionForCreation(Transaction domain) {
        if (getTransactionOutPort.existsByCode(domain.getCode()))
            throw new NotAcceptableException(ErrorMessages.TRANSACTION_CODE_ALREADY_EXISTS);
        if (getTransactionOutPort.existsByOfferAndRequestCode(domain.getOfferCode(), domain.getRequestCode()))
            throw new NotAcceptableException(ErrorMessages.UNABLE_TO_CREATE_TRANSACTION_TO_THIS_REQUEST);
        if (!getTransactionOutPort.checkIfPlacesInCarrierServiceRegion(domain.getCarrierUsername(), domain.getOfferCode(), domain.getRequestCode()))
            throw new NotAcceptableException(ErrorMessages.CARRIER_CANNOT_SERVE_THIS_PLACES);
    }
}
