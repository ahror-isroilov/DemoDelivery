package demo.delivery_project.region.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import demo.delivery_project.place.application.usecase.in.request.PlaceCreateRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionCreateRequest {
    @NotNull(message = ValidationMessages.REGION_NAME_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.PLACE_NAME_MUST_NOT_BE_NULL)
    private String name;

    private List<PlaceCreateRequest> places;
}
