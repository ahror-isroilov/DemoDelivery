package demo.delivery_project.product.application.domain.service;

import demo.delivery_project.product.application.domain.mapper.ProductRestMapper;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.in.GetProductUseCase;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetProductService implements GetProductUseCase {
    private final GetProductOutPort getProductOutPort;
    private final ProductRestMapper productRestMapper;

    @Override
    public ProductResponse get(UUID id) {
        Product product = getProductOutPort.get(id);
        return productRestMapper.mapToResponse(product);
    }

    @Override
    public List<ProductResponse> getAll(Pageable pageable) {
        return productRestMapper.mapToResponse(
                getProductOutPort.getAll(pageable)
        );
    }

    @Override
    public List<ProductResponse> getAllByOwner(UUID ownerId, Pageable pageable) {
        List<Product> ownedProducts = getProductOutPort.getAllByOwner(ownerId, pageable);
        return productRestMapper.mapToResponse(ownedProducts);
    }
}
