package demo.delivery_project.request.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.request.adapter.out.persistence.entity.RequestJpaEntity;
import demo.delivery_project.request.adapter.out.persistence.mapper.RequestPersistenceMapper;
import demo.delivery_project.request.adapter.out.persistence.repository.RequestJpaRepository;
import demo.delivery_project.request.application.domain.model.Request;
import demo.delivery_project.request.application.usecase.out.DeleteRequestOutPort;
import demo.delivery_project.request.application.usecase.out.GetRequestOutPort;
import demo.delivery_project.request.application.usecase.out.SaveRequestOutPort;
import demo.delivery_project.request.application.usecase.out.UpdateRequestOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestPersistenceAdapter implements SaveRequestOutPort, GetRequestOutPort, UpdateRequestOutPort, DeleteRequestOutPort {
    private final RequestJpaRepository requestJpaRepository;
    private final RequestPersistenceMapper requestPersistenceMapper;

    @Override
    public Request save(Request domain) {
        RequestJpaEntity entity = requestPersistenceMapper.mapToEntity(domain);
        RequestJpaEntity saved = requestJpaRepository.save(entity);
        return requestPersistenceMapper.mapToDomain(saved);
    }

    @Override
    public Request update(Request domain) {
        return save(domain);
    }

    @Override
    public Request get(UUID id) {
        RequestJpaEntity entity = requestJpaRepository.findById(id).orElseThrow(() -> new DataNotFoundException(ErrorMessages.OFFER_NOT_FOUND));
        return requestPersistenceMapper.mapToDomain(entity);
    }

    @Override
    public Boolean existsByCode(String code) {
        return requestJpaRepository.existsByCode(code);
    }

    @Override
    public List<Request> getAll(Pageable pageable) {
        Page<RequestJpaEntity> all = requestJpaRepository.findAll(pageable);
        return requestPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public List<Request> getAllByOwner(UUID ownerId, Pageable pageable) {
        Page<RequestJpaEntity> all = requestJpaRepository.findAllByCreatedBy(ownerId, pageable);
        return requestPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public Request getByCode(String code) {
        return requestPersistenceMapper.mapToDomain(
                requestJpaRepository.getByCode(code).orElseThrow(() -> new DataNotFoundException(ErrorMessages.REGION_NOT_FOUND))
        );
    }

    @Override
    public void delete(UUID id) {
        requestJpaRepository.deleteById(id);
    }
}
