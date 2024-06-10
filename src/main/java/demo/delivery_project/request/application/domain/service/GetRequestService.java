package demo.delivery_project.request.application.domain.service;

import demo.delivery_project.request.application.domain.mapper.RequestRestMapper;
import demo.delivery_project.request.application.domain.model.Request;
import demo.delivery_project.request.application.usecase.in.GetRequestUseCase;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import demo.delivery_project.request.application.usecase.out.GetRequestOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetRequestService implements GetRequestUseCase {
    private final RequestRestMapper requestRestMapper;
    private final GetRequestOutPort getRequestOutPort;

    @Override
    public RequestResponse get(UUID id) {
        return requestRestMapper.mapToResponse(getRequestOutPort.get(id));
    }

    @Override
    public RequestResponse getByCode(String code) {
        Request request = getRequestOutPort.getByCode(code);
        return requestRestMapper.mapToResponse(request);
    }

    @Override
    public List<RequestResponse> getAll(Pageable pageable) {
        return requestRestMapper.mapToResponse(getRequestOutPort.getAll(pageable));
    }

    @Override
    public List<RequestResponse> getAllByOwner(UUID ownerId, Pageable pageable) {
        return requestRestMapper.mapToResponse(getRequestOutPort.getAllByOwner(ownerId, pageable));
    }
}
