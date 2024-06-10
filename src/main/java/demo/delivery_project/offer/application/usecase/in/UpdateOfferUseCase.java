package demo.delivery_project.offer.application.usecase.in;

import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;

import java.util.UUID;

public interface UpdateOfferUseCase {
    OfferResponse update(UUID id, OfferUpdateRequest request);
}
