package demo.delivery_project.user.application.domain.service;

import demo.delivery_project.user.application.domain.mapper.UserRestMapper;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.in.GetUserUseCase;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import demo.delivery_project.user.application.usecase.out.GetUserOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {
    private final UserRestMapper userRestMapper;
    private final GetUserOutPort getUserOutPort;

    @Override
    public UserResponse get(UUID id) {
        User user = getUserOutPort.get(id);
        return userRestMapper.mapToResponse(user);
    }

    @Override
    public List<UserResponse> findAll(Pageable pageable) {
        List<User> all = getUserOutPort.findAll(pageable);
        return userRestMapper.mapToResponse(all);
    }

    @Override
    public List<UserResponse> findAllByRegion(String region) {
        return userRestMapper.mapToResponse(getUserOutPort.findAllByRegion(region));
    }
}
