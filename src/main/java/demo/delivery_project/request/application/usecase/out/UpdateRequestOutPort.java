package demo.delivery_project.request.application.usecase.out;

import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.request.application.domain.model.Request;

public interface UpdateRequestOutPort {
    Request update(Request domain);
}
