package demo.delivery_project.request.application.usecase.out;

import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.request.application.domain.model.Request;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetRequestOutPort {
    Request get(UUID id);

    Boolean existsByCode(String code);

    List<Request> getAll(Pageable pageable);

    List<Request> getAllByOwner(UUID ownerId, Pageable pageable);

    Request getByCode(String code);
}
