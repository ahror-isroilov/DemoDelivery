package demo.delivery_project.request.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import demo.delivery_project.request.application.domain.mapper.RequestRestMapper;
import demo.delivery_project.request.application.domain.model.Request;
import demo.delivery_project.request.application.usecase.in.SaveRequestUseCase;
import demo.delivery_project.request.application.usecase.in.request.RequestCreateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import demo.delivery_project.request.application.usecase.out.GetRequestOutPort;
import demo.delivery_project.request.application.usecase.out.SaveRequestOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveRequestService implements SaveRequestUseCase {
    private final SaveRequestOutPort saveRequestOutPort;
    private final RequestRestMapper offerRestMapper;
    private final GetRequestOutPort getRequestOutPort;
    private final GetPlaceOutPort getPlaceOutPort;
    private final GetProductOutPort getProductOutPort;

    @Override
    public RequestResponse save(RequestCreateRequest request) {
        checkForSave(request);
        Request req = offerRestMapper.mapToDomain(request);
        return offerRestMapper.mapToResponse(saveRequestOutPort.save(req));
    }

    private void checkForSave(RequestCreateRequest request) {
        if (!getProductOutPort.existsById(request.getProductId()))
            throw new DataNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);
        if (getRequestOutPort.existsByCode(request.getCode()))
            throw new NotAcceptableException(ErrorMessages.OFFER_CODE_ALREADY_EXISTS);
        if (!getPlaceOutPort.existsByName(request.getPlaceName()))
            throw new DataNotFoundException(ErrorMessages.PLACE_NOT_FOUND);
    }
}
