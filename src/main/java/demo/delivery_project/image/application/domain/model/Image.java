package demo.delivery_project.image.application.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
    private UUID id;
    private String path;
    private String name;
    private String originalName;
    private Long size;
    private UUID createdBy;
    private LocalDateTime createdAt;
}
