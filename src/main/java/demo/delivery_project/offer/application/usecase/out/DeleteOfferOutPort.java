package demo.delivery_project.offer.application.usecase.out;

import java.util.UUID;

public interface DeleteOfferOutPort {
    void delete(UUID id);
}
