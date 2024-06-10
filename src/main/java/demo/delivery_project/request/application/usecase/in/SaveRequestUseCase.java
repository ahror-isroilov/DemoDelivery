package demo.delivery_project.request.application.usecase.in;


import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.request.application.usecase.in.request.RequestCreateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;

public interface SaveRequestUseCase {
    RequestResponse save(RequestCreateRequest request);
}
