package demo.delivery_project.offer.application.usecase.in.request;

import demo.delivery_project.offer.adapter.out.persistence.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferUpdateRequest {
    private String placeName;
    private Status status;
}
