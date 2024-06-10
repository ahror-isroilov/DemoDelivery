package demo.delivery_project.offer.application.usecase.in;

import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetOfferUseCase {
    OfferResponse get(UUID id);

    OfferResponse getByCode(String code);

    List<OfferResponse> getAll(Pageable pageable);

    List<OfferResponse> getAllByOwner(UUID ownerId, Pageable pageable);
}
