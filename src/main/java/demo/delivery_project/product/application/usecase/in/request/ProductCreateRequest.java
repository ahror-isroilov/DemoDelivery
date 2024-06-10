package demo.delivery_project.product.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import jakarta.validation.constraints.Min;
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
public class ProductCreateRequest {
    @NotNull(message = ValidationMessages.PRODUCT_NAME_MUST_NOT_BE_NULL)
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.PRODUCT_NAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS)
    private String name;

    @NotNull(message = ValidationMessages.PRODUCT_CODE_MUST_NOT_BE_NULL)
    private String code;

    @NotNull(message = ValidationMessages.PRODUCT_NAME_MUST_NOT_BE_NULL)
    @Min(value = 0, message = ValidationMessages.INVALID_PRODUCT_PRICE)
    private Float price;

    @NotNull(message = ValidationMessages.PRODUCT_IMAGE_MUST_NOT_BE_NULL)
    private UUID imageId;
}
