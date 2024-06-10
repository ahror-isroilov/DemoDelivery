package demo.delivery_project.offer.application.usecase.out;

import demo.delivery_project.offer.application.domain.model.Offer;

public interface SaveOfferOutPort {
    Offer save(Offer domain);
}
