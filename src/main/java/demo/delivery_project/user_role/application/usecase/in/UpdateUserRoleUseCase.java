package demo.delivery_project.user_role.application.usecase.in;

import demo.delivery_project.user_role.application.usecase.in.request.UserRoleUpdateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;

import java.util.UUID;

public interface UpdateUserRoleUseCase {
    UserRoleResponse update(UUID id, UserRoleUpdateRequest request);
}
