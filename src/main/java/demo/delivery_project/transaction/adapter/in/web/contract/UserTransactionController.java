package demo.delivery_project.transaction.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("user/transaction")
public interface UserTransactionController {
    @PatchMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.EVALUATE_TRANSACTION + "\")")
    ResponseEntity<HashMap<String, Boolean>> evaluate(@RequestParam UUID id, @RequestParam Byte score);

    @GetMapping("/all-by-rcode")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_OWN_TRANSACTIONS + "\")")
    ResponseEntity<List<TransactionResponse>> getAllByRequestCode(@RequestParam String requestCode);
}
