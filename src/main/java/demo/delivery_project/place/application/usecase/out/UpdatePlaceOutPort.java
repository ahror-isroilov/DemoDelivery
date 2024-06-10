package demo.delivery_project.place.application.usecase.out;

import demo.delivery_project.place.application.domain.model.Place;

public interface UpdatePlaceOutPort {
    Place update(Place domain);
}
