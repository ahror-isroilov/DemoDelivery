package demo.delivery_project.transaction.application.usecase.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TotalTransactionScorePerCarrier {
    private UUID id;
    private String username;
    private Integer score;
}
