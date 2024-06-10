package demo.delivery_project.image.adapter.out.persistence.mapper;

import demo.delivery_project.image.adapter.out.persistence.entity.ImageJpaEntity;
import demo.delivery_project.image.application.domain.model.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImagePersistenceMapper {
    Image mapToDomain(ImageJpaEntity entity);

    ImageJpaEntity mapToEntity(Image domain);
}
