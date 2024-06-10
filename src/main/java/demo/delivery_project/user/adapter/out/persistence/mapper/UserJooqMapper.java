package demo.delivery_project.user.adapter.out.persistence.mapper;

import demo.delivery_project.jooq.tables.records.UsersRecord;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user_role.adapter.out.persistence.mapper.UserRoleJooqMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserRoleJooqMapper.class)
public interface UserJooqMapper {
    User mapToDomain(UsersRecord entity);

    List<User> mapToDomain(List<UsersRecord> entities);

    UsersRecord mapToRecord(User model);

    List<UsersRecord> mapToRecord(List<User> models);
}
