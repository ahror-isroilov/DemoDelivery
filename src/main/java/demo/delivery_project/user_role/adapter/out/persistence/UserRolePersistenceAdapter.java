package demo.delivery_project.user_role.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.jooq.Tables;
import demo.delivery_project.jooq.tables.records.RolesRecord;
import demo.delivery_project.user_role.adapter.out.persistence.mapper.UserRoleJooqMapper;
import demo.delivery_project.user_role.adapter.out.persistence.repository.UserRoleJooqRepository;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.out.DeleteUserRoleOutPort;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import demo.delivery_project.user_role.application.usecase.out.SaveUserRoleOutPort;
import demo.delivery_project.user_role.application.usecase.out.UpdateUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.jooq.Record;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRolePersistenceAdapter implements GetUserRoleOutPort, SaveUserRoleOutPort, UpdateUserRoleOutPort, DeleteUserRoleOutPort {
    private final UserRoleJooqRepository userRoleJooqRepository;
    private final UserRoleJooqMapper userRoleJooqMapper;

    @Override
    public UserRole get(UUID id) {
        Optional<Record> roleOptional = userRoleJooqRepository.get(id);
        if (roleOptional.isEmpty())
            throw new DataNotFoundException(ErrorMessages.USER_ROLE_NOT_FOUND);
        Record record = roleOptional.get();
        return new UserRole(
                record.get(Tables.ROLES.ID),
                record.get(Tables.ROLES.NAME),
                record.get("permissions", Set.class),
                record.get(Tables.ROLES.IS_DELETED)
        );
    }

    @Override
    public UserRole getByUserId(UUID userId) {
        Optional<Record> roleOptional = userRoleJooqRepository.getByUserId(userId);
        if (roleOptional.isEmpty())
            throw new DataNotFoundException(ErrorMessages.USER_NOT_FOUND);
        Record record = roleOptional.get();
        return new UserRole(
                record.get(Tables.ROLES.ID),
                record.get(Tables.ROLES.NAME),
                record.get("permissions", Set.class),
                record.get(Tables.ROLES.IS_DELETED)
        );
    }

    @Override
    public List<UserRole> getAll(Pageable pageable) {
        List<RolesRecord> all = userRoleJooqRepository.getAll(pageable);
        return userRoleJooqMapper.mapToDomain(all);
    }

    @Override
    public UserRole save(UserRole domain) {
        RolesRecord record = userRoleJooqRepository.create(userRoleJooqMapper.mapToRecord(domain), domain);
        return userRoleJooqMapper.mapToDomain(record);
    }

    @Override
    public void delete(UUID id) {
        userRoleJooqRepository.delete(id);
    }

    @Override
    public UserRole update(UserRole domain) {
        RolesRecord record = userRoleJooqRepository.update(userRoleJooqMapper.mapToRecord(domain));
        return userRoleJooqMapper.mapToDomain(record);
    }
}
