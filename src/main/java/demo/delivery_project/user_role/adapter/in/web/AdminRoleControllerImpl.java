package demo.delivery_project.user_role.adapter.in.web;

import demo.delivery_project.user_role.adapter.in.web.contracts.AdminRoleController;
import demo.delivery_project.user_role.application.usecase.in.DeleteUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.GetUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.SaveUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.UpdateUserRoleUseCase;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleCreateRequest;
import demo.delivery_project.user_role.application.usecase.in.request.UserRoleUpdateRequest;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AdminRoleControllerImpl implements AdminRoleController {
    private final SaveUserRoleUseCase saveUserRoleUseCase;
    private final GetUserRoleUseCase getUserRoleUseCase;
    private final UpdateUserRoleUseCase updateUserRoleUseCase;
    private final DeleteUserRoleUseCase deleteUserRoleUseCase;

    @Override
    public ResponseEntity<UserRoleResponse> save(UserRoleCreateRequest request) {
        return new ResponseEntity<>(saveUserRoleUseCase.save(request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserRoleResponse> get(UUID id) {
        return new ResponseEntity<>(getUserRoleUseCase.get(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserRoleResponse>> getAll(Integer page, Integer size) {
        return new ResponseEntity<>(getUserRoleUseCase.getAll(
                PageRequest.of(page, size)), HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<UserRoleResponse> update(UUID id, UserRoleUpdateRequest request) {
        return new ResponseEntity<>(updateUserRoleUseCase.update(id, request), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> delete(UUID id) {
        return new ResponseEntity<>(deleteUserRoleUseCase.delete(id), HttpStatus.OK);
    }
}
