package demo.delivery_project.product.application.usecase.out;

import java.util.UUID;

public interface DeleteProductOutPort {
    void delete(UUID id);
}
