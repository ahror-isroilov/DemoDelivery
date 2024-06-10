package demo.delivery_project.user.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {
    @NotNull(message = ValidationMessages.USERNAME_MUST_NOT_BE_NULL)
    @Size(min = 3, message = ValidationMessages.USERNAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = ValidationMessages.USERNAME_MUST_CONTAIN_ONLY_LETTERS_AND_NUMBERS)
    private String username;

    @NotNull(message = ValidationMessages.FIRSTNAME_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.FIRSTNAME_MUST_HAVE_AT_LEAST_3_AND_ONLY_LETTERS)
    private String firstname;

    @NotNull(message = ValidationMessages.LASTNAME_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.LASTNAME_MUST_HAVE_AT_LEAST_3_AND_ONLY_LETTERS)
    private String lastname;

    @NotNull(message = ValidationMessages.EMAIL_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = ValidationMessages.INVALID_EMAIL_ADDRESS)
    private String email;

    private String imageId;

    @NotNull(message = ValidationMessages.PASSWORD_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!#@$*])[A-Za-z\\d!#@$*]{8,}$", message = ValidationMessages.ENTER_VALID_PASSWORD)
    private String password;

    private String passwordHash;

    @NotNull(message = ValidationMessages.ROLE_MUST_NOT_BE_NULL)
    private UUID roleId;
}
