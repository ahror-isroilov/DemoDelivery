package demo.delivery_project.image.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.image.adapter.out.persistence.entity.ImageJpaEntity;
import demo.delivery_project.image.adapter.out.persistence.mapper.ImagePersistenceMapper;
import demo.delivery_project.image.adapter.out.persistence.repository.ImageJpaRepository;
import demo.delivery_project.image.application.domain.model.Image;
import demo.delivery_project.image.application.usecase.out.GetImageOutPort;
import demo.delivery_project.image.application.usecase.out.SaveImageOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImagePersistenceAdapter implements SaveImageOutPort, GetImageOutPort {
    private final ImageJpaRepository imageJpaRepository;
    private final ImagePersistenceMapper imagePersistenceMapper;

    @Override
    public Image get(UUID id) {
        ImageJpaEntity image = imageJpaRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessages.IMAGE_NOT_FOUND));
        return imagePersistenceMapper.mapToDomain(image);
    }

    @Override
    public Boolean existsById(UUID id) {
        return imageJpaRepository.existsById(id);
    }

    @Override
    public Image save(Image domain) {
        ImageJpaEntity save = imageJpaRepository.save(imagePersistenceMapper.mapToEntity(domain));
        return imagePersistenceMapper.mapToDomain(save);
    }
}
