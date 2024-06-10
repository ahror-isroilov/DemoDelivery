package demo.delivery_project.user.application.usecase.in;

import demo.delivery_project.user.application.usecase.in.request.UserCreateRequest;
import demo.delivery_project.user.application.usecase.in.response.UserResponse;

public interface SaveUserUseCase {
    UserResponse save(UserCreateRequest request);
}
