package demo.delivery_project.user_role.application.usecase.out;

import demo.delivery_project.user_role.application.domain.model.UserRole;

public interface UpdateUserRoleOutPort {
    UserRole update(UserRole domain);
}
