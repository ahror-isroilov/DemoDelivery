package demo.delivery_project.user.application.domain.model;

import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private UUID id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private UUID imageId;
    private String password;
    private String passwordHash;
    private UserStatus status;
    private UUID roleId;
    private LocalDateTime createdAt;
    private UUID createdBy;
}
