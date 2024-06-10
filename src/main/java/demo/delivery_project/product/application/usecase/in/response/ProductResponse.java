package demo.delivery_project.product.application.usecase.in.response;

import demo.delivery_project.image.application.usecase.in.response.ImageUrlResponse;
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
public class ProductResponse {
    private UUID id;
    private String name;
    private String code;
    private Float price;
    private ImageUrlResponse image;
}
