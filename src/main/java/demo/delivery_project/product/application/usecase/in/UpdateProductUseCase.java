package demo.delivery_project.product.application.usecase.in;

import demo.delivery_project.product.application.usecase.in.request.ProductUpdateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;

import java.util.UUID;

public interface UpdateProductUseCase {
    ProductResponse update(UUID id, ProductUpdateRequest request);
}
