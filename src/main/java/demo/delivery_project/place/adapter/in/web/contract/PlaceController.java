package demo.delivery_project.place.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.place.application.usecase.in.request.PlaceCreateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RequestMapping("/admin/places")
public interface PlaceController {
    @PostMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PLACE_CREATE + "\")")
    ResponseEntity<PlaceResponse> save(@RequestBody PlaceCreateRequest request);

    @GetMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PLACE_READ + "\")")
    ResponseEntity<PlaceResponse> get(@RequestParam UUID id);

    @GetMapping("/all")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PLACE_READ + "\")")
    ResponseEntity<Page<PlaceResponse>> getAll(@RequestParam Integer page, @RequestParam Integer size);

    @DeleteMapping
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.PLACE_DELETE + "\")")
    ResponseEntity<HashMap<String, Boolean>> delete(@RequestParam UUID id);
}
