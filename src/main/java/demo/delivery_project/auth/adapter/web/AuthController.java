package demo.delivery_project.auth.adapter.web;

import demo.delivery_project.auth.application.usecase.in.request.LoginRequest;
import demo.delivery_project.auth.application.usecase.in.request.RegisterRequest;
import demo.delivery_project.token.application.usecase.in.response.AccessTokenResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/login")
    ResponseEntity<AccessTokenResponse> login(@Valid @RequestBody LoginRequest request);

    @PostMapping("/register")
    ResponseEntity<AccessTokenResponse> register(@Valid @RequestBody RegisterRequest request);
}
