package demo.delivery_project.region.adapter.in.web;

import demo.delivery_project.region.adapter.in.web.contract.UserRegionController;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.GetRegionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRegionControllerImpl implements UserRegionController {
    private final GetRegionUseCase getRegionUseCase;

    @Override
    public ResponseEntity<List<RegionWithPlaceProjection>> getAll() {
        return
                new ResponseEntity<>(getRegionUseCase.getRegionsWithPlaces(), HttpStatus.OK);
    }
}
