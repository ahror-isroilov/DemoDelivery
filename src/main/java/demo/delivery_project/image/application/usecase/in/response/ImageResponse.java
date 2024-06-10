package demo.delivery_project.image.application.usecase.in.response;

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
public class ImageResponse {
    private UUID id;
    private String path;
    private String name;
    private String originalName;
    private Long size;
    private Long createdBy;
    private LocalDateTime createdAt;
}
