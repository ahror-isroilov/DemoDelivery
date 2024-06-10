package demo.delivery_project.offer.adapter.in.web;

import demo.delivery_project.common.util.SecurityUtils;
import demo.delivery_project.offer.adapter.in.web.contract.OfferUserController;
import demo.delivery_project.offer.application.usecase.in.DeleteOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.GetOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.SaveOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.UpdateOfferUseCase;
import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
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
public class OfferUserControllerImpl implements OfferUserController {
    private final SaveOfferUseCase saveOfferUseCase;
    private final GetOfferUseCase getRequestUseCase;
    private final UpdateOfferUseCase updateOfferUseCase;
    private final DeleteOfferUseCase deleteRequestUseCase;

    @Override

    public ResponseEntity<OfferResponse> save(OfferCreateRequest request) {
        return new ResponseEntity<>(saveOfferUseCase.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OfferResponse> get(UUID id) {
        return new ResponseEntity<>(getRequestUseCase.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OfferResponse>> getAll(Integer page, Integer size) {
        return new ResponseEntity<>(getRequestUseCase.getAll(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<OfferResponse>> getAllByOwner(Integer page, Integer size) {
        return new ResponseEntity<>(getRequestUseCase.getAllByOwner(
                SecurityUtils.getCurrentUserId(),
                PageRequest.of(page, size)
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OfferResponse> update(OfferUpdateRequest request, UUID id) {
        return new ResponseEntity<>(updateOfferUseCase.update(SecurityUtils.getCurrentUserId(), request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HashMap<String, Boolean>> delete(UUID id) {
        deleteRequestUseCase.delete(id);
        return new ResponseEntity<>(new HashMap<>() {{
            put("sucess", true);
        }}, HttpStatus.OK);
    }
}
