package demo.delivery_project.request.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.request.application.domain.mapper.RequestRestMapper;
import demo.delivery_project.request.application.domain.model.Request;
import demo.delivery_project.request.application.usecase.in.UpdateRequestUseCase;
import demo.delivery_project.request.application.usecase.in.request.RequestUpdateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import demo.delivery_project.request.application.usecase.out.GetRequestOutPort;
import demo.delivery_project.request.application.usecase.out.UpdateRequestOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateRequestService implements UpdateRequestUseCase {
    private final UpdateRequestOutPort updateRequestOutPort;
    private final RequestRestMapper requestRestMapper;
    private final GetRequestOutPort getRequestOutPort;
    private final GetPlaceOutPort getPlaceOutPort;

    @Override
    public RequestResponse update(UUID id, RequestUpdateRequest request) {
        Request req = getRequestOutPort.get(id);
        if (!getPlaceOutPort.existsByName(request.getPlaceName()))
            throw new DataNotFoundException(ErrorMessages.PLACE_NOT_FOUND);
        return requestRestMapper.mapToResponse(updateRequestOutPort.update(requestRestMapper.mapToDomain(request, req)));
    }
}
