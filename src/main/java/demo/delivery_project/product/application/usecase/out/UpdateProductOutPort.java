package demo.delivery_project.product.application.usecase.out;

import demo.delivery_project.product.application.domain.model.Product;

public interface UpdateProductOutPort {
    Product update(Product domain);
}
