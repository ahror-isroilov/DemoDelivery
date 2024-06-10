package demo.delivery_project.user.application.usecase.in;

import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetUserUseCase {
    UserResponse get(UUID id);

    List<UserResponse> findAll(Pageable pageable);

    List<UserResponse> findAllByRegion(String region);
}
