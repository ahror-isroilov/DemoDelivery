package demo.delivery_project.image.adapter.out.persistence.entity;

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
@Table(name = "images")
public class ImageJpaEntity extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String path;

    private String name;

    @Column(name = "original_name")
    private String originalName;

    private Long size;
}
