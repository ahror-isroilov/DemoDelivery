package demo.delivery_project.transaction.application.usecase.in.response;

import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
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
public class TransactionResponse {
    private UUID id;
    private Byte score;
    private String code;
    private String carrierUsername;
    private RequestResponse request;
    private OfferResponse offer;
    private LocalDateTime performTime;
    private LocalDateTime createdAt;
    private UUID createdBy;
}
