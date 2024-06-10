package demo.delivery_project.product.adapter.out.persistence.entity;

import demo.delivery_project.common.auditing.Auditable;
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
@Table(name = "products")
public class ProductJpaEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "price", nullable = false)
    private Float price = 0f;

    @Column(name = "imageId")
    private UUID imageId;
}
