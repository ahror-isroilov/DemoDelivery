package demo.delivery_project.product.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.product.application.usecase.in.request.ProductCreateRequest;
import demo.delivery_project.product.application.usecase.in.request.ProductUpdateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("/user/products")
public interface UserProductController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PRODUCT_CREATE + "\")")
    ResponseEntity<ProductResponse> save(@RequestBody @Valid ProductCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PRODUCT_READ + "\")")
    ResponseEntity<ProductResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USER_PRODUCTS + "\")")
    ResponseEntity<List<ProductResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @GetMapping("/all-by-owner")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_OWN_PRODUCTS + "\")")
    ResponseEntity<List<ProductResponse>> getAllByOwner(@RequestParam Integer page, @RequestParam Integer size);


    @PutMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PRODUCT_UPDATE + "\")")
    ResponseEntity<ProductResponse> update(@RequestBody @Valid ProductUpdateRequest request, @RequestParam UUID id);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PRODUCT_DELETE + "\")")
    ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam UUID id);
}
