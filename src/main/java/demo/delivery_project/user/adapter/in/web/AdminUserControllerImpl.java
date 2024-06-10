package demo.delivery_project.user.adapter.in.web;

import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.adapter.in.web.contracts.AdminUserController;
import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user.application.usecase.in.DeleteUserUseCase;
import demo.delivery_project.user.application.usecase.in.GetUserUseCase;
import demo.delivery_project.user.application.usecase.in.SaveUserUseCase;
import demo.delivery_project.user.application.usecase.in.UpdateUserUseCase;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;
import demo.delivery_project.user.application.usecase.in.request.UserCreateRequest;
import demo.delivery_project.user.application.usecase.in.request.UserUpdateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdminUserControllerImpl implements AdminUserController {
    private final SaveUserUseCase saveUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;

    @Override
    public ResponseEntity<UserResponse> save(UserCreateRequest request) {
        UserResponse response = saveUserUseCase.save(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RegionResponse>> setCarrierRegions(SetCarrierRegionsRequest request) {
        return new ResponseEntity<>(updateUserUseCase.setCarrierRegions(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> get(UUID id) {
        UserResponse response = getUserUseCase.get(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAll(Integer page, Integer size) {
        List<UserResponse> response = getUserUseCase.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAllByRegion(String region) {
        return new ResponseEntity<>(getUserUseCase.findAllByRegion(region), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> update(UserUpdateRequest request, UUID id) {
        UserResponse response = updateUserUseCase.update(id, request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> update(UUID id, UserStatus status) {
        return new ResponseEntity<>(updateUserUseCase.updateStatus(id, status), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> delete(UUID id) {
        return new ResponseEntity<>(deleteUserUseCase.delete(id), HttpStatus.OK);
    }
}
