package demo.delivery_project.auth.adapter.web;

import demo.delivery_project.auth.application.usecase.in.AuthorizeUseCase;
import demo.delivery_project.auth.application.usecase.in.request.LoginRequest;
import demo.delivery_project.auth.application.usecase.in.request.RegisterRequest;
import demo.delivery_project.token.application.usecase.in.response.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthorizeUseCase authorizeUseCase;

    @Override
    public ResponseEntity<AccessTokenResponse> login(LoginRequest request) {
        AccessTokenResponse login = authorizeUseCase.login(request);
        return new ResponseEntity<>(login,
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AccessTokenResponse> register(RegisterRequest request) {
        AccessTokenResponse register = authorizeUseCase.register(request);
        return new ResponseEntity<>(register,
                HttpStatus.OK);
    }
}
