package demo.delivery_project.request.application.usecase.in.request;

import demo.delivery_project.offer.adapter.out.persistence.enumeration.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateRequest {
    private String placeName;
    private Status status;
}
