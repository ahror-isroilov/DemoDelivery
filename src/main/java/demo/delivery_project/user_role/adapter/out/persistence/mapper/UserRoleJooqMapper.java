package demo.delivery_project.user_role.adapter.out.persistence.mapper;

import demo.delivery_project.jooq.tables.records.RolesRecord;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserRoleJooqMapper {
    UserRole mapToDomain(RolesRecord record);

    List<UserRole> mapToDomain(List<RolesRecord> entities);

    RolesRecord mapToRecord(UserRole model);

    List<RolesRecord> mapToRecord(List<UserRole> models);
}
