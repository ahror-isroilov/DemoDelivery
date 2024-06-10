package demo.delivery_project.transaction.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/admin/statistics")
public interface TransactionStatisticsController {

    @GetMapping("/transaction-count-per-region")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.STATISTICS + "\")")
    ResponseEntity<?> getTransactionCountPerRegion();

    @GetMapping("/total-transaction-score-per-carrier")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.STATISTICS + "\")")
    ResponseEntity<?> getTotalTransactionScorePerCarrier(@RequestParam Integer minScore);

    @GetMapping("/total-transaction-count-per-product")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.STATISTICS + "\")")
    ResponseEntity<?> getTransactionCountPerProduct();
}
