package demo.delivery_project.request.application.usecase.in;

import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.request.application.usecase.in.request.RequestUpdateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;

import java.util.UUID;

public interface UpdateRequestUseCase {
    RequestResponse update(UUID id, RequestUpdateRequest request);
}
