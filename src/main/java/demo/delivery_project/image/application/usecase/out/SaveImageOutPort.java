package demo.delivery_project.image.application.usecase.out;

import demo.delivery_project.image.application.domain.model.Image;

public interface SaveImageOutPort {
    Image save(Image domain);
}
