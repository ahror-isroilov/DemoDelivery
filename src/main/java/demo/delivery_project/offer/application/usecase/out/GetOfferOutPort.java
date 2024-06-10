package demo.delivery_project.offer.application.usecase.out;

import demo.delivery_project.offer.application.domain.model.Offer;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetOfferOutPort {
    Offer get(UUID id);

    Boolean existsByCode(String code);

    List<Offer> getAll(Pageable pageable);

    List<Offer> getAllByOwner(UUID ownerId, Pageable pageable);

    Offer getByCode(String code);
}
