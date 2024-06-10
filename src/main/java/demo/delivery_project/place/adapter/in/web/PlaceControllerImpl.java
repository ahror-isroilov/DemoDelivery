package demo.delivery_project.place.adapter.in.web;

import demo.delivery_project.place.adapter.in.web.contract.PlaceController;
import demo.delivery_project.place.application.usecase.in.DeletePlaceUseCase;
import demo.delivery_project.place.application.usecase.in.GetPlaceUseCase;
import demo.delivery_project.place.application.usecase.in.SavePlaceUseCase;
import demo.delivery_project.place.application.usecase.in.request.PlaceCreateRequest;
import demo.delivery_project.place.application.usecase.in.response.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PlaceControllerImpl implements PlaceController {
    private final SavePlaceUseCase savePlaceUseCase;
    private final GetPlaceUseCase getPlaceUseCase;
    private final DeletePlaceUseCase deletePlaceUseCase;

    @Override
    public ResponseEntity<PlaceResponse> save(PlaceCreateRequest request) {
        return new ResponseEntity<>(savePlaceUseCase.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PlaceResponse> get(UUID id) {
        return
                new ResponseEntity<>(
                        getPlaceUseCase.get(id), HttpStatus.OK
                );
    }

    @Override
    public ResponseEntity<Page<PlaceResponse>> getAll(Integer page, Integer size) {
        return new ResponseEntity<>(
                getPlaceUseCase.getAll(PageRequest.of(page, size)), HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<HashMap<String, Boolean>> delete(UUID id) {
        deletePlaceUseCase.delete(id);
        return new ResponseEntity<>(new HashMap<>() {{
            put("success", true);
        }}, HttpStatus.OK);
    }
}
