package demo.delivery_project.user.application.usecase.out;

import demo.delivery_project.user.application.domain.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GetUserOutPort {
    User get(UUID id);

    User getByUsernameOrEmail(String value);

    Boolean existsByEmailAndUsername(String email, String username);

    Boolean existsByUsernameOrEmail(String value);

    List<User> findAll(Pageable pageable);

    List<User> findAllByRegion(String region);
}
