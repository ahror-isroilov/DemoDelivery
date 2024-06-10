package demo.delivery_project.user_role.application.usecase.out;

import demo.delivery_project.user_role.application.domain.model.UserRole;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetUserRoleOutPort {
    UserRole get(UUID id);

    UserRole getByUserId(UUID userId);

    List<UserRole> getAll(Pageable pageable);
}
