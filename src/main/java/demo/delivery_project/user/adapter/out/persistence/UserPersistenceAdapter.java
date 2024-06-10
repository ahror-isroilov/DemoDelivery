package demo.delivery_project.user.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.jooq.tables.records.UsersRecord;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.adapter.out.persistence.mapper.UserJooqMapper;
import demo.delivery_project.user.adapter.out.persistence.repository.UserJooqRepository;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;
import demo.delivery_project.user.application.usecase.out.DeleteUserOutPort;
import demo.delivery_project.user.application.usecase.out.GetUserOutPort;
import demo.delivery_project.user.application.usecase.out.SaveUserOutPort;
import demo.delivery_project.user.application.usecase.out.UpdateUserOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserOutPort, GetUserOutPort, UpdateUserOutPort, DeleteUserOutPort {
    private final UserJooqRepository userJooqRepository;
    private final UserJooqMapper userJooqMapper;

    @Override
    public void delete(UUID id) {
        userJooqRepository.delete(id);
    }

    @Override
    public User get(UUID id) {
        Optional<UsersRecord> usersRecord = userJooqRepository.get(id);
        if (usersRecord.isEmpty())
            throw new DataNotFoundException(ErrorMessages.USER_NOT_FOUND);
        return userJooqMapper.mapToDomain(usersRecord.get());
    }

    @Override
    public User getByUsernameOrEmail(String value) {
        Optional<UsersRecord> userRecord = userJooqRepository.getByUsernameOrEmail(value);
        if (userRecord.isEmpty()) throw new DataNotFoundException(ErrorMessages.USER_NOT_FOUND);
        return userJooqMapper.mapToDomain(userRecord.get());
    }

    @Override
    public Boolean existsByEmailAndUsername(String email, String username) {
        return userJooqRepository.existsByEmailAndUsername(email, username);
    }

    @Override
    public Boolean existsByUsernameOrEmail(String value) {
        return userJooqRepository.existsByUsernameOrEmail(value);
    }

    @Override
    public List<User> findAll(Pageable pageable) {
        List<UsersRecord> all = userJooqRepository.findAll(pageable);
        return userJooqMapper.mapToDomain(all);
    }

    @Override
    public List<User> findAllByRegion(String region) {
        List<UsersRecord> record = userJooqRepository.findAllByRegion(region);
        return userJooqMapper.mapToDomain(record);
    }

    @Override
    public User save(User domain) {
        UsersRecord entity = userJooqRepository.create(
                userJooqMapper.mapToRecord(domain)
        );
        return userJooqMapper.mapToDomain(entity);
    }

    @Override
    public User update(User domain) {
        UsersRecord record = userJooqRepository.update(userJooqMapper.mapToRecord(domain)).orElseThrow(RuntimeException::new);
        return userJooqMapper.mapToDomain(record);
    }

    @Override
    public List<RegionResponse> setCarrierRegions(SetCarrierRegionsRequest request) {
        return userJooqRepository.storeCarrierRegions(request);
    }
}
