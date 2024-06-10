package demo.delivery_project.product.application.domain.service;

import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.in.DeleteProductUseCase;
import demo.delivery_project.product.application.usecase.out.DeleteProductOutPort;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteProductService implements DeleteProductUseCase {
    private final GetProductOutPort getProductOutPort;
    private final DeleteProductOutPort deleteProductOutPort;

    @Override
    public void delete(UUID id) {
        Product product = getProductOutPort.get(id);
        if (!product.getCreatedBy().equals(SecurityUtils.getCurrentUserId()))
            throw new NotAcceptableException(ErrorMessages.PROCESS_DENIED);
        deleteProductOutPort.delete(id);
    }
}
