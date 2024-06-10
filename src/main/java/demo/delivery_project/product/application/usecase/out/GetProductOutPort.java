package demo.delivery_project.product.application.usecase.out;

import demo.delivery_project.product.application.domain.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetProductOutPort {
    Product get(UUID id);

    List<Product> getAll(Pageable pageable);

    List<Product> getAllByOwner(UUID ownerId, Pageable pageable);

    Boolean existsByOwnerAndName(UUID ownerId, String name);
    Boolean existsById(UUID id);

    Boolean existsByOwnerAndCode(UUID ownerId, String code);
}
