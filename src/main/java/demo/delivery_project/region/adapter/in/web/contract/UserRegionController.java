package demo.delivery_project.region.adapter.in.web.contract;

import demo.delivery_project.common.constant.PermissionConstants;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/user/regions")
public interface UserRegionController {
    @GetMapping("/all-with-places")
    @PreAuthorize("hasAuthority(\"" + PermissionConstants.GET_REGIONS_AND_PLACES + "\")")
    ResponseEntity<List<RegionWithPlaceProjection>> getAll();
}
