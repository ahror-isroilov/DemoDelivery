package demo.delivery_project.region.adapter.in.web;

import demo.delivery_project.region.adapter.in.web.contract.AdminRegionController;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.in.DeleteRegionUseCase;
import demo.delivery_project.region.application.usecase.in.GetRegionUseCase;
import demo.delivery_project.region.application.usecase.in.SaveRegionUseCase;
import demo.delivery_project.region.application.usecase.in.UpdateRegionUseCase;
import demo.delivery_project.region.application.usecase.in.request.RegionCreateRequest;
import demo.delivery_project.region.application.usecase.in.request.RegionUpdateRequest;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdminRegionControllerImpl implements AdminRegionController {
    private final SaveRegionUseCase saveRegionUseCase;
    private final GetRegionUseCase getRegionUseCase;
    private final UpdateRegionUseCase updateRegionUseCase;
    private final DeleteRegionUseCase deleteRegionUseCase;

    @Override
    public ResponseEntity<RegionResponse> save(RegionCreateRequest request) {
        return new ResponseEntity<>(
                saveRegionUseCase.save(request),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<RegionResponse> get(UUID id) {
        return new ResponseEntity<>(getRegionUseCase.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<RegionResponse>> getAll(Integer page, Integer size) {
        Page<RegionResponse> all = getRegionUseCase.getAll(PageRequest.of(page, size));
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RegionWithPlaceProjection>> getAll() {
        return
                new ResponseEntity<>(getRegionUseCase.getRegionsWithPlaces(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RegionWithPlaceProjection> update(RegionUpdateRequest request, UUID id) {
        RegionWithPlaceProjection update = updateRegionUseCase.update(id, request);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap<String, Boolean>> delete(UUID id) {
        deleteRegionUseCase.delete(id);
        return new ResponseEntity<>(new HashMap<>() {{
            put("success", true);
        }}, HttpStatus.OK);
    }
}
