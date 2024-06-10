package demo.delivery_project.user_role.application.domain.service;

import demo.delivery_project.user_role.application.domain.mapper.UserRoleRestMapper;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.in.UpdateUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleUpdateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import demo.delivery_project.user_role.application.usecase.out.UpdateUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserRoleService implements UpdateUserRoleUseCase {
    private final UserRoleRestMapper roleRestMapper;
    private final GetUserRoleOutPort getUserRoleOutPort;
    private final UpdateUserRoleOutPort updateUserRoleOutPort;

    @Override
    public UserRoleResponse update(UUID id, UserRoleUpdateRequest request) {
        UserRole role = getUserRoleOutPort.get(id);
        UserRole updatedRole = roleRestMapper.mapToDomain(request, role);
        return roleRestMapper.mapToResponse(updateUserRoleOutPort.update(updatedRole));
    }
}
