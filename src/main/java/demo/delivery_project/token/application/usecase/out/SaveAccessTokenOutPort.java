package demo.delivery_project.token.application.usecase.out;

import demo.delivery_project.token.application.domain.model.AccessToken;

public interface SaveAccessTokenOutPort {
    AccessToken save(AccessToken domain);
}
