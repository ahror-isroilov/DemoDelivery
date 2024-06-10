package demo.delivery_project.user.application.usecase.in;

import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;
import demo.delivery_project.user.application.usecase.in.request.UserUpdateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UpdateUserUseCase {
    UserResponse update(UUID id, UserUpdateRequest request);

    UserResponse updateStatus(UUID id, UserStatus status);

    List<RegionResponse> setCarrierRegions(SetCarrierRegionsRequest request);
}
