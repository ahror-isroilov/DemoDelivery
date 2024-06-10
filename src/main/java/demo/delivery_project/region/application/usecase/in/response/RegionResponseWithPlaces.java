package demo.delivery_project.region.application.usecase.in.response;

import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class RegionResponseWithPlaces {
        private UUID id;
        private String name;
        private List<PlaceResponse> places;
    }
