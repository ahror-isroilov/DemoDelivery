package demo.delivery_project.product.application.usecase.in;

import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetProductUseCase {
    ProductResponse get(UUID id);

    List<ProductResponse> getAll(Pageable pageable);

    List<ProductResponse> getAllByOwner(UUID ownerId, Pageable pageable);
}
