package demo.delivery_project.user_role.application.usecase.in;

import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetUserRoleUseCase {
    UserRoleResponse get(UUID id);

    List<UserRoleResponse> getAll(Pageable pageable);
}
