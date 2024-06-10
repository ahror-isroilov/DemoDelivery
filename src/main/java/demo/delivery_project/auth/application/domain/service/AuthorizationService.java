package demo.delivery_project.auth.application.domain.service;

import demo.delivery_project.auth.application.usecase.in.AuthorizeUseCase;
import demo.delivery_project.auth.application.usecase.in.request.LoginRequest;
import demo.delivery_project.auth.application.usecase.in.request.RegisterRequest;
import demo.delivery_project.common.constant.Constants;
import demo.delivery_project.common.exception.BadCredentialsException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.common.exception.UserDisabledException;
import demo.delivery_project.common.password_encoder.CustomPasswordEncoder;
import demo.delivery_project.common.util.BaseUtils;
import demo.delivery_project.token.application.domain.mapper.AccessTokenRestMapper;
import demo.delivery_project.token.application.domain.model.AccessToken;
import demo.delivery_project.token.application.usecase.in.response.AccessTokenResponse;
import demo.delivery_project.token.application.usecase.out.SaveAccessTokenOutPort;
import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.out.GetUserOutPort;
import demo.delivery_project.user.application.usecase.out.SaveUserOutPort;
import demo.delivery_project.user_role.adapter.out.persistence.repository.UserRoleJooqRepository;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import demo.delivery_project.user_role.application.usecase.out.SaveUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements AuthorizeUseCase {
    private final GetUserOutPort getUserOutPort;
    private final GetUserRoleOutPort getUserRoleOutPort;
    private final SaveUserOutPort saveUserOutPort;
    private final CustomPasswordEncoder passwordEncoder;
    private final SaveAccessTokenOutPort saveAccessTokenOutPort;
    private final AccessTokenRestMapper accessTokenRestMapper;
    private final SaveUserRoleOutPort saveUserRoleOutPort;
    @Override
    public AccessTokenResponse login(LoginRequest request) {
        User user = getUserOutPort.getByUsernameOrEmail(request.getLogin());
        if (user.getStatus().equals(UserStatus.DISABLED))
            throw new UserDisabledException();
        checkPassword(request.getPassword(), user.getPassword(), user.getPasswordHash());
        AccessToken token = generateAccessToken(user);
        return accessTokenRestMapper.mapToResponse(saveAccessTokenOutPort.save(token));
    }

    @Override
    public AccessTokenResponse register(RegisterRequest request) {
        checkEmailAndUsername(request);
        UserRole role = saveUserRoleOutPort.save(UserRole.User());
        User user = saveUserOutPort.save(
                User.builder()
                        .id(UUID.randomUUID())
                        .username(request.getUsername())
                        .firstname(request.getFirstname())
                        .lastname(request.getLastname())
                        .email(request.getEmail())
                        .passwordHash(Constants.BCRYPT_PASSWORD_HASH)
                        .password(passwordEncoder.encodeWith(request.getPassword(), Constants.BCRYPT_PASSWORD_HASH))
                        .status(UserStatus.ENABLED)
                        .roleId(role.getId())
                        .build()
        );
        AccessToken accessToken = generateAccessToken(user);
        return accessTokenRestMapper.mapToResponse(saveAccessTokenOutPort.save(accessToken));
    }

    private AccessToken generateAccessToken(User user) {
        return new AccessToken(
                BaseUtils.generateUniqueString(Constants.TOKEN_LENGTH),
                user.getId(),
                LocalDateTime.now().plusSeconds(Constants.ACCESS_TOKEN_EXPIRATION_S),
                false
        );
    }

    private void checkPassword(String rawPassword, String password, String hash) {
        if (!passwordEncoder.matchesWith(rawPassword, password, hash))
            throw new BadCredentialsException();
    }

    private void checkEmailAndUsername(RegisterRequest request) {
        if (getUserOutPort.existsByUsernameOrEmail(request.getEmail()))
            throw new NotAcceptableException(ErrorMessages.EMAIL_ALREADY_EXISTS);

        if (getUserOutPort.existsByUsernameOrEmail(request.getUsername()))
            throw new NotAcceptableException(ErrorMessages.USER_NOT_FOUND);
    }
}
