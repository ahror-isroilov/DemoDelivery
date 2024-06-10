package demo.delivery_project.user.application.domain.service;

import demo.delivery_project.common.constant.Constants;
import demo.delivery_project.common.password_encoder.CustomPasswordEncoder;
import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user.application.domain.mapper.UserRestMapper;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.in.SaveUserUseCase;
import demo.delivery_project.user.application.usecase.in.request.UserCreateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import demo.delivery_project.user.application.usecase.out.SaveUserOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveUserService implements SaveUserUseCase {
    private final UserRestMapper userRestMapper;
    private final SaveUserOutPort saveUserOutPort;
    private final CustomPasswordEncoder passwordEncoder;

    @Override
    public UserResponse save(UserCreateRequest request) {
        User domain = userRestMapper.mapToDomain(request);
        domain.setId(UUID.randomUUID());
        domain.setPasswordHash(request.getPasswordHash() != null ? request.getPasswordHash() : Constants.BCRYPT_PASSWORD_HASH);
        domain.setPassword(passwordEncoder.encodeWith(request.getPassword(), domain.getPasswordHash()));
        domain.setStatus(UserStatus.ENABLED);
        User user = saveUserOutPort.save(domain);
        return userRestMapper.mapToResponse(user);
    }
}
