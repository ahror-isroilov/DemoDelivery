package demo.delivery_project.offer.application.usecase.in.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferCreateRequest {
    private UUID productId;
    private String code;
    private String placeName;
}
