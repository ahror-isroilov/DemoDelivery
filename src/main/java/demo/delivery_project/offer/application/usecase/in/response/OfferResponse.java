package demo.delivery_project.offer.application.usecase.in.response;

import demo.delivery_project.offer.adapter.out.persistence.enumeration.Status;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {
    private UUID id;
    private ProductResponse product;
    private String code;
    private String placeName;
    private Status status;
}

