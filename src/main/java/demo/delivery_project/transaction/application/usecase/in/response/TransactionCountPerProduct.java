package demo.delivery_project.transaction.application.usecase.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCountPerProduct {
    private String productCode;
    private Integer transactionCount;
}
