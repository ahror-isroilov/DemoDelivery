package demo.delivery_project.transaction.application.domain.mapper;

import demo.delivery_project.offer.application.usecase.in.GetOfferUseCase;
import demo.delivery_project.request.application.usecase.in.GetRequestUseCase;
import demo.delivery_project.transaction.application.domain.model.Transaction;
import demo.delivery_project.transaction.application.usecase.in.request.TransactionCreateRequest;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TransactionRestMapper {
    @Autowired
    GetOfferUseCase getOfferUseCase;
    @Autowired
    GetRequestUseCase getRequestUseCase;

    public abstract Transaction mapToDomain(TransactionCreateRequest request);

    @Mapping(target = "offer", ignore = true)
    @Mapping(target = "request", ignore = true)
    public abstract TransactionResponse mapToResponse(Transaction domain);

    public abstract List<TransactionResponse> mapToResponse(List<Transaction> domain);

    @AfterMapping
    public void afterMapping(@MappingTarget TransactionResponse response, Transaction domain) {
        response.setRequest(getRequestUseCase.getByCode(domain.getRequestCode()));
        response.setOffer(getOfferUseCase.getByCode(domain.getOfferCode()));
    }
}
