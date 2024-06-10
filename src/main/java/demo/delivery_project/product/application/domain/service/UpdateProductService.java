package demo.delivery_project.product.application.domain.service;

import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.product.application.domain.mapper.ProductRestMapper;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.in.UpdateProductUseCase;
import demo.delivery_project.product.application.usecase.in.request.ProductUpdateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import demo.delivery_project.product.application.usecase.out.UpdateProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {
    private final UpdateProductOutPort updateProductOutPort;
    private final ProductRestMapper productRestMapper;
    private final GetProductOutPort getProductOutPort;

    @Override
    public ProductResponse update(UUID id, ProductUpdateRequest request) {
        Product product = getProductOutPort.get(id);
        checkExists(request);
        Product updated = updateProductOutPort.update(productRestMapper.mapToDomain(request, product));
        return productRestMapper.mapToResponse(updated);
    }

    private void checkExists(ProductUpdateRequest request) {
        if (getProductOutPort.existsByOwnerAndName(SecurityUtils.getCurrentUserId(), request.getName()) ||
                getProductOutPort.existsByOwnerAndCode(SecurityUtils.getCurrentUserId(), request.getCode()))
            throw new NotAcceptableException(ErrorMessages.PRODUCT_ALREADY_EXISTS);
    }
}
