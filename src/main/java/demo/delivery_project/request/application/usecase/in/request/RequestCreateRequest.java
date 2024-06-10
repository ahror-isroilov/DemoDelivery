package demo.delivery_project.request.application.usecase.in.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateRequest {
    private UUID productId;
    private String code;
    private String placeName;
}
