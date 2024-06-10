package demo.delivery_project.place.adapter.out.persistence.entity;

import demo.delivery_project.region.adapter.out.persistence.entity.RegionJpaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "places")
@SQLDelete(sql = "is_deleted = true")
@SQLRestriction(value = "is_deleted = false")
public class PlaceJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionJpaEntity region;

    @Column(name = "is_deleted")
    private Boolean isDeleted = Boolean.FALSE;
}
