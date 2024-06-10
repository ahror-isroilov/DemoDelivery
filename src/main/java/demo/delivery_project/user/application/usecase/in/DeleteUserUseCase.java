package demo.delivery_project.user.application.usecase.in;

import java.util.UUID;

public interface DeleteUserUseCase {
    boolean delete(UUID id);
}
