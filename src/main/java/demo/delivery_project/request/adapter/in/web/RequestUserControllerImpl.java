package demo.delivery_project.request.adapter.in.web;

import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.request.adapter.in.web.contract.RequestUserController;
import demo.delivery_project.request.application.usecase.in.DeleteRequestUseCase;
import demo.delivery_project.request.application.usecase.in.GetRequestUseCase;
import demo.delivery_project.request.application.usecase.in.SaveRequestUseCase;
import demo.delivery_project.request.application.usecase.in.UpdateRequestUseCase;
import demo.delivery_project.request.application.usecase.in.request.RequestCreateRequest;
import demo.delivery_project.request.application.usecase.in.request.RequestUpdateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class RequestUserControllerImpl implements RequestUserController {
    private final SaveRequestUseCase saveRequestUseCase;
    private final GetRequestUseCase getRequestUseCase;
    private final UpdateRequestUseCase updateRequestUseCase;
    private final DeleteRequestUseCase deleteRequestUseCase;

    @Override

    public ResponseEntity<RequestResponse> save(RequestCreateRequest request) {
        return new ResponseEntity<>(saveRequestUseCase.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RequestResponse> get(UUID id) {
        return new ResponseEntity<>(getRequestUseCase.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RequestResponse>> getAll(Integer page, Integer size) {
        return new ResponseEntity<>(getRequestUseCase.getAll(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RequestResponse>> getAllByOwner(Integer page, Integer size) {
        return new ResponseEntity<>(getRequestUseCase.getAllByOwner(
                SecurityUtils.getCurrentUserId(),
                PageRequest.of(page, size)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<RequestResponse> update(RequestUpdateRequest request, UUID id) {
        return new ResponseEntity<>(updateRequestUseCase.update(SecurityUtils.getCurrentUserId(), request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap<String, Boolean>> delete(UUID id) {
        deleteRequestUseCase.delete(id);
        return new ResponseEntity<>(new HashMap<>() {{
            put("sucess", true);
        }}, HttpStatus.OK);
    }
}
