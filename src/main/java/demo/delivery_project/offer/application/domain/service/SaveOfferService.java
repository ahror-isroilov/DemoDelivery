package demo.delivery_project.offer.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.offer.application.domain.mapper.OfferRestMapper;
import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.offer.application.usecase.in.SaveOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.offer.application.usecase.out.GetOfferOutPort;
import demo.delivery_project.offer.application.usecase.out.SaveOfferOutPort;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveOfferService implements SaveOfferUseCase {
    private final SaveOfferOutPort saveOfferOutPort;
    private final OfferRestMapper offerRestMapper;
    private final GetOfferOutPort getOfferOutPort;
    private final GetPlaceOutPort getPlaceOutPort;
    private final GetProductOutPort getProductOutPort;

    @Override
    public OfferResponse save(OfferCreateRequest request) {
        checkForSave(request);
        Offer offer = offerRestMapper.mapToDomain(request);
        return offerRestMapper.mapToResponse(saveOfferOutPort.save(offer));
    }

    private void checkForSave(OfferCreateRequest request) {
        if (!getProductOutPort.existsById(request.getProductId()))
            throw new DataNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND);
        if (getOfferOutPort.existsByCode(request.getCode()))
            throw new NotAcceptableException(ErrorMessages.OFFER_CODE_ALREADY_EXISTS);
        if (!getPlaceOutPort.existsByName(request.getPlaceName()))
            throw new DataNotFoundException(ErrorMessages.PLACE_NOT_FOUND);
    }
}
