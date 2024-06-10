package demo.delivery_project.product.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.image.application.usecase.out.GetImageOutPort;
import demo.delivery_project.product.application.domain.mapper.ProductRestMapper;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.in.SaveProductUseCase;
import demo.delivery_project.product.application.usecase.in.request.ProductCreateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import demo.delivery_project.product.application.usecase.out.SaveProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {
    private final SaveProductOutPort saveProductOutPort;
    private final GetProductOutPort getProductOutPort;
    private final ProductRestMapper productRestMapper;
    private final GetImageOutPort getImageOutPort;

    @Override
    public ProductResponse save(ProductCreateRequest request) {
        checkExists(request);
        Product product = saveProductOutPort.save(productRestMapper.mapToDomain(request));
        return productRestMapper.mapToResponse(product);
    }

    private void checkExists(ProductCreateRequest request) {
        if (!getImageOutPort.existsById(request.getImageId()))
            throw new DataNotFoundException(ErrorMessages.IMAGE_NOT_FOUND);
        if (getProductOutPort.existsByOwnerAndName(SecurityUtils.getCurrentUserId(), request.getName()) ||
                getProductOutPort.existsByOwnerAndCode(SecurityUtils.getCurrentUserId(), request.getCode()))
            throw new NotAcceptableException(ErrorMessages.PRODUCT_ALREADY_EXISTS);
    }
}
