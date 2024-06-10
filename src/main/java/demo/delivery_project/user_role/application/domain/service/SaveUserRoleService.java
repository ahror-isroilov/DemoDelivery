package demo.delivery_project.user_role.application.domain.service;

import demo.delivery_project.user_role.application.domain.mapper.UserRoleRestMapper;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.in.SaveUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleCreateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import demo.delivery_project.user_role.application.usecase.out.SaveUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveUserRoleService implements SaveUserRoleUseCase {
    private final UserRoleRestMapper roleRestMapper;
    private final SaveUserRoleOutPort saveUserRoleOutPort;

    @Override
    public UserRoleResponse save(UserRoleCreateRequest request) {
        UserRole role = roleRestMapper.mapToDomain(request);
        role.setId(UUID.randomUUID());
        role.setIsDeleted(false);
        UserRole userRole = saveUserRoleOutPort.save(role);
        return roleRestMapper.mapToResponse(userRole);
    }
}
