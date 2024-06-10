package demo.delivery_project.token.application.usecase.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenResponse {
    private String token;
    private LocalDateTime expiration;
    private Boolean isDeleted;
}
