package demo.delivery_project.offer.application.domain.service;

import demo.delivery_project.offer.application.domain.mapper.OfferRestMapper;
import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.offer.application.usecase.in.GetOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.offer.application.usecase.out.GetOfferOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetOfferService implements GetOfferUseCase {
    private final OfferRestMapper offerRestMapper;
    private final GetOfferOutPort getOfferOutPort;

    @Override
    public OfferResponse get(UUID id) {
        return offerRestMapper.mapToResponse(getOfferOutPort.get(id));
    }

    @Override
    public OfferResponse getByCode(String code) {
        Offer offer = getOfferOutPort.getByCode(code);
        return offerRestMapper.mapToResponse(offer);
    }

    @Override
    public List<OfferResponse> getAll(Pageable pageable) {
        return offerRestMapper.mapToResponse(getOfferOutPort.getAll(pageable));
    }

    @Override
    public List<OfferResponse> getAllByOwner(UUID ownerId, Pageable pageable) {
        return offerRestMapper.mapToResponse(getOfferOutPort.getAllByOwner(ownerId, pageable));
    }
}
