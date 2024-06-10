package demo.delivery_project.offer.application.usecase.in;


import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;

public interface SaveOfferUseCase {
    OfferResponse save(OfferCreateRequest request);
}
