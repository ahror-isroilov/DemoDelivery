package demo.delivery_project.transaction.adapter.out.persistence.entity;

import demo.delivery_project.common.auditing.Auditable;
import jakarta.persistence.*;
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
@Entity
@Table(name = "transactions")
public class TransactionJpaEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "score")
    private Byte score = 0;

    @Column(name = "code")
    private String code;

    @Column(name = "carrier_username")
    private String carrierUsername;

    @Column(name = "request_code")
    private String requestCode;

    @Column(name = "offer_code")
    private String offerCode;

    @Column(name = "perform_time")
    private LocalDateTime performTime;
}
