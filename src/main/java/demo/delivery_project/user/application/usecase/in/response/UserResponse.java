package demo.delivery_project.user.application.usecase.in.response;

import demo.delivery_project.user.application.domain.enumeration.UserStatus;
import demo.delivery_project.user_role.application.usecase.in.response.UserRoleResponse;
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
public class UserResponse {
    private UUID id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private UUID imageId;
    private String password;
    private String passwordHash;
    private UserStatus status;
    private UserRoleResponse role;
    private LocalDateTime createdAt;
    private UUID createdBy;
}
