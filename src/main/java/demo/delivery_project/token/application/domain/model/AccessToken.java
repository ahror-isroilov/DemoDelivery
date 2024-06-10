package demo.delivery_project.token.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessToken {
    private String token;
    private UUID userId;
    private LocalDateTime expiration;
    private Boolean isDeleted;

    public boolean isExpired() {
        return expiration.isBefore(LocalDateTime.now());
    }
}
