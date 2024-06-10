package demo.delivery_project.user_role.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleUpdateRequest {
    @NotNull(message = ValidationMessages.ROLE_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z]{3,}$\n", message = ValidationMessages.ROLE_NAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS)
    private String name;

    private Set<String> permissions;
}
