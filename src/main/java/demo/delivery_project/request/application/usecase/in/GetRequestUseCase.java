package demo.delivery_project.request.application.usecase.in;

import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetRequestUseCase {
    RequestResponse get(UUID id);

    RequestResponse getByCode(String code);

    List<RequestResponse> getAll(Pageable pageable);

    List<RequestResponse> getAllByOwner(UUID ownerId, Pageable pageable);
}
