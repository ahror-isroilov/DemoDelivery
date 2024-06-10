package demo.delivery_project.user_role.application.domain.model;

import demo.delivery_project.user_role.application.domain.enumeration.UserDefaultPermissions;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {
    private UUID id = UUID.randomUUID();
    private String name;
    private Set<String> permissions;
    private Boolean isDeleted = Boolean.FALSE;

    public static UserRole User() {
        UserRole role = new UserRole();
        role.setName("USER");
        role.setIsDeleted(false);
        role.setPermissions(UserDefaultPermissions.USER.getDefaultPermissions());
        return role;
    }
}
