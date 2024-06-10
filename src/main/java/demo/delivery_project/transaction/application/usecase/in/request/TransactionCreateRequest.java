package demo.delivery_project.transaction.application.usecase.in.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreateRequest {
    private String code;
    private String carrierUsername;
    private String requestCode;
    private String offerCode;
}
