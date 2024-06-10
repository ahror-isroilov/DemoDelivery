package demo.delivery_project.user_role.application.usecase.in;

import demo.delivery_project.user_role.application.usecase.in.request.UserRoleCreateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;

public interface SaveUserRoleUseCase {
    UserRoleResponse save(UserRoleCreateRequest request);
}
