package demo.delivery_project.transaction.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.transaction.application.usecase.in.request.TransactionCreateRequest;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("carrier/transaction")
public interface CarrierTransactionController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.TRANSACTION_CREATE + "\")")
    ResponseEntity<TransactionResponse> save(@RequestBody @Valid TransactionCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.TRANSACTION_READ + "\")")
    ResponseEntity<TransactionResponse> get(@RequestParam UUID id);

    @GetMapping("/all-by-owner")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_OWN_TRANSACTIONS + "\")")
    ResponseEntity<List<TransactionResponse>> getAllByOwner(@RequestParam Integer page, @RequestParam Integer size);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.TRANSACTION_DELETE + "\")")
    ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam UUID id);
}
