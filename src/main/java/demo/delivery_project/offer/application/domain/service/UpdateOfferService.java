package demo.delivery_project.offer.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.offer.application.domain.mapper.OfferRestMapper;
import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.offer.application.usecase.in.UpdateOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.offer.application.usecase.out.GetOfferOutPort;
import demo.delivery_project.offer.application.usecase.out.UpdateOfferOutPort;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateOfferService implements UpdateOfferUseCase {
    private final UpdateOfferOutPort updateOfferOutPort;
    private final OfferRestMapper offerRestMapper;
    private final GetOfferOutPort getOfferOutPort;
    private final GetPlaceOutPort getPlaceOutPort;

    @Override
    public OfferResponse update(UUID id, OfferUpdateRequest request) {
        Offer offer = getOfferOutPort.get(id);
        if (!getPlaceOutPort.existsByName(request.getPlaceName()))
            throw new DataNotFoundException(ErrorMessages.PLACE_NOT_FOUND);
        return offerRestMapper.mapToResponse(updateOfferOutPort.update(offerRestMapper.mapToDomain(request, offer)));
    }
}
