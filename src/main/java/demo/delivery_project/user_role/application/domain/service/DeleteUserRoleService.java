package demo.delivery_project.user_role.application.domain.service;

import demo.delivery_project.user_role.application.usecase.in.DeleteUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.out.DeleteUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserRoleService implements DeleteUserRoleUseCase {
    private final DeleteUserRoleOutPort deleteUserRoleOutPort;

    @Override
    public Boolean delete(UUID id) {
        deleteUserRoleOutPort.delete(id);
        return true;
    }
}
