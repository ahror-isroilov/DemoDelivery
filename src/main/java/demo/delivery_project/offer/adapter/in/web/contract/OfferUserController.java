package demo.delivery_project.offer.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("user/offers")
public interface OfferUserController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.OFFER_CREATE + "\")")
    ResponseEntity<OfferResponse> save(@RequestBody @Valid OfferCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.OFFER_READ + "\")")
    ResponseEntity<OfferResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USER_OFFERS + "\")")
    ResponseEntity<List<OfferResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @GetMapping("/all-by-owner")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USER_REQUESTS + "\")")
    ResponseEntity<List<OfferResponse>> getAllByOwner(@RequestParam Integer page, @RequestParam Integer size);

    @PutMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.OFFER_UPDATE + "\")")
    ResponseEntity<OfferResponse> update(@RequestBody @Valid OfferUpdateRequest request, @RequestParam UUID id);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.OFFER_DELETE + "\")")
    ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam UUID id);
}
