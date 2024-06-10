package demo.delivery_project.user.application.domain.mapper;

import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.in.request.UserCreateRequest;
import demo.delivery_project.user.application.usecase.in.request.UserUpdateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import demo.delivery_project.user_role.application.domain.mapper.UserRoleRestMapper;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserRoleRestMapper.class})
public abstract class UserRestMapper {
    public abstract UserResponse mapToResponse(UserCreateRequest request);

    public abstract UserResponse mapToResponse(User domain);

    public abstract List<UserResponse> mapToResponse(List<User> domains);

    public abstract User mapToDomain(UserCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract User mapToDomain(UserUpdateRequest request, @MappingTarget User domain);
}
