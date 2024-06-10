package demo.delivery_project.token.application.usecase.in.response;

import demo.delivery_project.user.application.usecase.in.response.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponse {
    private String token;
    private UUID userId;
    private LocalDateTime expiration;
    private Boolean isDeleted;
}
