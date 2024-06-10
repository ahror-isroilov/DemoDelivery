package demo.delivery_project.user_role.application.domain.mapper;

import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleCreateRequest;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleUpdateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class UserRoleRestMapper {
    @Autowired
    GetUserRoleOutPort getUserRoleOutPort;

    public abstract UserRoleResponse mapToResponse(UserRole domain);

    public abstract List<UserRoleResponse> mapToResponse(List<UserRole> domains);

    public abstract UserRole mapToDomain(UserRoleCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract UserRole mapToDomain(UserRoleUpdateRequest request, @MappingTarget UserRole domain);

    public UserRole mapToDomain(UUID id) {
        return getUserRoleOutPort.get(id);
    }
}
