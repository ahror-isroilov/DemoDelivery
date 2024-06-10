package demo.delivery_project.product.application.usecase.in.request;

import demo.delivery_project.common.constant.ValidationMessages;
import jakarta.validation.constraints.Min;
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
public class ProductUpdateRequest {
    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.PRODUCT_NAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS)
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{3,}$", message = ValidationMessages.PRODUCT_NAME_MUST_CONTAIN_AT_LEAST_3_CHARACTERS)
    private String code;

    @Min(value = 0, message = ValidationMessages.INVALID_PRODUCT_PRICE)
    private Float price;

    private UUID imageId;

}
