package demo.delivery_project.user_role.application.usecase.in.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleResponse {
    private UUID id;
    private String name;
    private Set<String> permissions;
    private UUID userId;
    private Boolean isDeleted;
}
