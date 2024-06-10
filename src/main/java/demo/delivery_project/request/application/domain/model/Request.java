package demo.delivery_project.request.application.domain.model;

import demo.delivery_project.offer.adapter.out.persistence.enumeration.Status;
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
public class Request {
    private UUID id = UUID.randomUUID();
    private UUID productId;
    private String code;
    private String placeName;
    private Status status = Status.OPEN;
    private LocalDateTime createdAt = LocalDateTime.now();
    private UUID createdBy;
}
