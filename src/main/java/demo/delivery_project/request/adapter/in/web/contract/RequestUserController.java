package demo.delivery_project.request.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.request.application.usecase.in.request.RequestCreateRequest;
import demo.delivery_project.request.application.usecase.in.request.RequestUpdateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("user/requests")
public interface RequestUserController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REQUEST_CREATE + "\")")
    ResponseEntity<RequestResponse> save(@RequestBody @Valid RequestCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REQUEST_READ + "\")")
    ResponseEntity<RequestResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USER_REQUESTS + "\")")
    ResponseEntity<List<RequestResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @GetMapping("/all-by-owner")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USER_REQUESTS + "\")")
    ResponseEntity<List<RequestResponse>> getAllByOwner(@RequestParam Integer page, @RequestParam Integer size);

    @PutMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REQUEST_UPDATE + "\")")
    ResponseEntity<RequestResponse> update(@RequestBody @Valid RequestUpdateRequest request, @RequestParam UUID id);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REQUEST_DELETE + "\")")
    ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam UUID id);
}
