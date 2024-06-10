package demo.delivery_project.region.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import demo.delivery_project.region.application.usecase.in.request.RegionUpdateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RequestMapping("/admin/regions")
public interface AdminRegionController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REGION_CREATE + "\")")
    ResponseEntity<RegionResponse> save(@RequestBody RegionCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REGION_READ + "\")")
    ResponseEntity<RegionResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REGION_READ + "\")")
    ResponseEntity<Page<RegionResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @GetMapping("/all-with-places")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_REGIONS_AND_PLACES + "\")")
    ResponseEntity<List<RegionWithPlaceProjection>> getAll();

    @PutMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REGION_UPDATE + "\")")
    ResponseEntity<RegionWithPlaceProjection> update(@RequestBody RegionUpdateRequest request, @RequestParam UUID id);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.REGION_DELETE + "\")")
    ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam UUID id);
}
