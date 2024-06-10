package demo.delivery_project.token.application.usecase.out;

import demo.delivery_project.token.application.domain.model.AccessToken;

import java.util.Optional;

public interface GetAccessTokenOutPort {
    AccessToken get(String token);

    Optional<AccessToken> getOptional(String token);
}
