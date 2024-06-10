package demo.delivery_project.user_role.adapter.in.web.contracts;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleCreateRequest;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleUpdateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/roles")
public interface AdminRoleController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.ROLE_CREATE + "\")")
    ResponseEntity<UserRoleResponse> save(@RequestBody @Valid UserRoleCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.ROLE_READ + "\")")
    ResponseEntity<UserRoleResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.ROLE_READ + "\")")
    ResponseEntity<List<UserRoleResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @PutMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.ROLE_UPDATE + "\")")
    ResponseEntity<UserRoleResponse> update(@RequestParam UUID id, @RequestBody UserRoleUpdateRequest request);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.ROLE_DELETE + "\")")
    ResponseEntity<Boolean> delete(@RequestParam UUID id);
}
