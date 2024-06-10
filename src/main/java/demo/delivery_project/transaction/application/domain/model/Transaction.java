package demo.delivery_project.transaction.application.domain.model;

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
public class Transaction {
    private UUID id = UUID.randomUUID();
    private Byte score = 0;
    private String code;
    private String carrierUsername;
    private String requestCode;
    private String offerCode;
    private LocalDateTime performTime;
    private LocalDateTime createdAt = LocalDateTime.now();
    private UUID createdBy;
}
