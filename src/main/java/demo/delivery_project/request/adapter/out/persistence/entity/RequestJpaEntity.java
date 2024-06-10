package demo.delivery_project.request.adapter.out.persistence.entity;

import demo.delivery_project.common.auditing.Auditable;
import demo.delivery_project.offer.adapter.out.persistence.enumeration.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "requests")
public class RequestJpaEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "product_id")
    private UUID productId;

    @Column(name = "code")
    private String code;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
