package demo.delivery_project.product.application.domain.model;

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
public class Product {
    private UUID id = UUID.randomUUID();
    private String name;
    private String code;
    private Float price;
    private UUID imageId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private UUID createdBy;
}
