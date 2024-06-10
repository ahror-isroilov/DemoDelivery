package demo.delivery_project.image.application.domain.mapper;

import demo.delivery_project.common.constant.Constants;
import demo.delivery_project.image.application.domain.model.Image;
import demo.delivery_project.image.application.usecase.in.response.ImageUrlResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ImageRestMapper {
    public ImageUrlResponse mapToResponse(Image domain) {
        if (domain == null) return null;
        return new ImageUrlResponse(
                domain.getId(),
                Constants.FILE_VIEW_URL + domain.getId()
        );
    }
}
