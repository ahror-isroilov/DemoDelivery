package demo.delivery_project.user.application.domain.service;

import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user.application.domain.mapper.UserRestMapper;
import demo.delivery_project.user.application.domain.model.User;
import demo.delivery_project.user.application.usecase.in.UpdateUserUseCase;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;
import demo.delivery_project.user.application.usecase.in.request.UserUpdateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import demo.delivery_project.user.application.usecase.out.GetUserOutPort;
import demo.delivery_project.user.application.usecase.out.UpdateUserOutPort;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import demo.delivery_project.user_role.application.usecase.out.GetUserRoleOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {
    private final UpdateUserOutPort updateUserOutPort;
    private final UserRestMapper userRestMapper;
    private final GetUserOutPort getUserOutPort;
    private final GetUserRoleOutPort getUserRoleOutPort;

    @Override
    public UserResponse update(UUID id, UserUpdateRequest request) {
        User user = getUserOutPort.get(id);
        User updatedUser = userRestMapper.mapToDomain(request, user);
        return userRestMapper.mapToResponse(updateUserOutPort.update(updatedUser));
    }

    @Override
    public UserResponse updateStatus(UUID id, UserStatus status) {
        User user = getUserOutPort.get(id);
        user.setStatus(status);
        return userRestMapper.mapToResponse(updateUserOutPort.update(user));
    }

    @Override
    public List<RegionResponse> setCarrierRegions(SetCarrierRegionsRequest request) {
        User user = getUserOutPort.getByUsernameOrEmail(request.getUsername());
        UserRole role = getUserRoleOutPort.get(user.getRoleId());
        if (!role.getName().equals("CARRIER"))
            throw new NotAcceptableException(ErrorMessages.USER_IS_NOT_CARRIER);
        return updateUserOutPort.setCarrierRegions(request);
    }
}
