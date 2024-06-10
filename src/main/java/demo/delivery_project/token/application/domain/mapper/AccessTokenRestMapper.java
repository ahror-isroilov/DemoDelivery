package demo.delivery_project.token.application.domain.mapper;

import demo.delivery_project.token.application.domain.model.AccessToken;
import demo.delivery_project.token.application.usecase.in.response.AccessTokenResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccessTokenRestMapper {
    AccessToken mapToDomain(AccessTokenResponse response);

    AccessTokenResponse mapToResponse(AccessToken domain);
}
