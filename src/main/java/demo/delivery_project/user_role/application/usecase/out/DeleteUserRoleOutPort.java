package demo.delivery_project.user_role.application.usecase.out;

import java.util.UUID;

public interface DeleteUserRoleOutPort {
    void delete(UUID id);
}
