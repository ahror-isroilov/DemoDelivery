package demo.delivery_project.auth.application.usecase.in;

import demo.delivery_project.auth.application.usecase.in.request.LoginRequest;
import demo.delivery_project.auth.application.usecase.in.request.RegisterRequest;
import demo.delivery_project.token.application.usecase.in.response.AccessTokenResponse;

public interface AuthorizeUseCase {
    AccessTokenResponse login(LoginRequest request);

    AccessTokenResponse register(RegisterRequest request);
}
