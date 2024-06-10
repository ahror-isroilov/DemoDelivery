package demo.delivery_project.place.application.usecase.out;

import demo.delivery_project.place.application.domain.model.Place;

import java.util.List;

public interface SavePlaceOutPort {
    Place save(Place domain);

    List<Place> saveAll(List<Place> places);
}
