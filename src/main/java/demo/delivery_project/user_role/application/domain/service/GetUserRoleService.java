package demo.delivery_project.user_role.application.domain.service;

import demo.delivery_project.user_role.application.domain.mapper.UserRoleRestMapper;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.in.GetUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserRoleService implements GetUserRoleUseCase {
    private final UserRoleRestMapper roleRestMapper;
    private final GetUserRoleOutPort getUserRoleOutPort;

    @Override
    public UserRoleResponse get(UUID id) {
        return roleRestMapper.mapToResponse(getUserRoleOutPort.get(id));
    }

    @Override
    public List<UserRoleResponse> getAll(Pageable pageable) {
        List<UserRole> all = getUserRoleOutPort.getAll(pageable);
        return roleRestMapper.mapToResponse(all);
    }
}
