package demo.delivery_project.product.application.usecase.in;

import demo.delivery_project.product.application.usecase.in.request.ProductCreateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;

public interface SaveProductUseCase {
    ProductResponse save(ProductCreateRequest request);
}
