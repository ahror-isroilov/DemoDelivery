package demo.delivery_project.product.adapter.in.web;

import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.product.adapter.in.web.contract.UserProductController;
import demo.delivery_project.product.application.usecase.in.DeleteProductUseCase;
import demo.delivery_project.product.application.usecase.in.GetProductUseCase;
import demo.delivery_project.product.application.usecase.in.SaveProductUseCase;
import demo.delivery_project.product.application.usecase.in.UpdateProductUseCase;
import demo.delivery_project.product.application.usecase.in.request.ProductCreateRequest;
import demo.delivery_project.product.application.usecase.in.request.ProductUpdateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserProductControllerImpl implements UserProductController {
    private final SaveProductUseCase saveProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @Override
    public ResponseEntity<ProductResponse> save(ProductCreateRequest request) {
        ProductResponse response = saveProductUseCase.save(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> get(UUID id) {
        ProductResponse response = getProductUseCase.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAll(Integer page, Integer size) {
        List<ProductResponse> response = getProductUseCase.getAll(PageRequest.of(page, size));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllByOwner(Integer page, Integer size) {
        List<ProductResponse> response = getProductUseCase.getAllByOwner(SecurityUtils.getCurrentUserId(), PageRequest.of(page, size));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductResponse> update(ProductUpdateRequest request, UUID id) {
        ProductResponse response = updateProductUseCase.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap<String, Boolean>> delete(UUID id) {
        deleteProductUseCase.delete(id);
        return new ResponseEntity<>(new HashMap<>() {{
            put("success", true);
        }}, HttpStatus.OK);
    }
}
