package demo.delivery_project.user.adapter.in.web.contracts;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;
import demo.delivery_project.user.application.usecase.in.request.UserCreateRequest;
import demo.delivery_project.user.application.usecase.in.request.UserUpdateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/users")
public interface AdminUserController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.USER_CREATE + "\")")
    ResponseEntity<UserResponse> save(@Valid @RequestBody UserCreateRequest request);

    @PostMapping("/set-carrier-regions")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.SET_CARRIER_REGIONS + "\")")
    ResponseEntity<List<RegionResponse>> setCarrierRegions(@Valid @RequestBody SetCarrierRegionsRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.USER_READ + "\")")
    ResponseEntity<UserResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USERS + "\")")
    ResponseEntity<List<UserResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @GetMapping("/all-by-region")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_USERS + "\")")
    ResponseEntity<List<UserResponse>> getAllByRegion(@RequestParam String region);

    @PutMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.USER_UPDATE + "\")")
    ResponseEntity<UserResponse> update(@Valid @RequestBody UserUpdateRequest request, @RequestParam UUID id);

    @PatchMapping("/update/status")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.USER_UPDATE + "\")")
    ResponseEntity<UserResponse> update(@RequestParam UUID id, @RequestParam UserStatus status);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.USER_DELETE + "\")")
    ResponseEntity<Boolean> delete(@RequestParam UUID id);
}
