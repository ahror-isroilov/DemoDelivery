package demo.delivery_project.place.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceCreateRequest {
    @NotNull(message = ValidationMessages.PLACE_NAME_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.PLACE_NAME_MUST_NOT_BE_NULL)
    private String name;

    @NotNull(message = ValidationMessages.REGION_ID_MUST_NOT_BE_NULL)
    private UUID regionId;
}
