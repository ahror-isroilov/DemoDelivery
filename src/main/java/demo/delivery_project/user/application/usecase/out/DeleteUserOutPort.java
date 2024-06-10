package demo.delivery_project.user.application.usecase.out;

import java.util.UUID;

public interface DeleteUserOutPort {
    void delete(UUID id);
}
