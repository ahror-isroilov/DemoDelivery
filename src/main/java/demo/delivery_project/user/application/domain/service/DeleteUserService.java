package demo.delivery_project.user.application.domain.service;

import demo.delivery_project.user.application.usecase.in.DeleteUserUseCase;
import demo.delivery_project.user.application.usecase.out.DeleteUserOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {
    private final DeleteUserOutPort deleteUserOutPort;

    @Override
    public boolean delete(UUID id) {
        try {
            deleteUserOutPort.delete(id);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }
}
