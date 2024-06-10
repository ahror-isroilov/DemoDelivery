package demo.delivery_project.user.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SetCarrierRegionsRequest {
    @NotNull(message = ValidationMessages.USERNAME_MUST_NOT_BE_NULL)
    @Size(min = 3, message = ValidationMessages.USERNAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = ValidationMessages.USERNAME_MUST_CONTAIN_ONLY_LETTERS_AND_NUMBERS)
    private String username;

    @NotNull(message = ValidationMessages.REGIONS_FIELD_MUST_NOT_BE_NULL)
    @NotEmpty(message = ValidationMessages.SET_AT_LEAST_ONE_REGION)
    private Set<String> regions;
}
