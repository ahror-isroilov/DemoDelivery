package demo.delivery_project.image.application.usecase.out;

import demo.delivery_project.image.application.domain.model.Image;

import java.util.UUID;

public interface GetImageOutPort {
    Image get(UUID id);

    Boolean existsById(UUID id);
}
