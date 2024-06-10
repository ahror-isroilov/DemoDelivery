package demo.delivery_project.image.application.domain.service;

import demo.delivery_project.common.constant.Constants;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.common.util.BaseUtils;
import demo.delivery_project.image.application.domain.model.Image;
import demo.delivery_project.image.application.usecase.in.response.ImageUrlResponse;
import demo.delivery_project.image.application.usecase.in.response.UploadImageUseCase;
import demo.delivery_project.image.application.usecase.out.SaveImageOutPort;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UploadImageService implements UploadImageUseCase {
    private final SaveImageOutPort saveImageOutPort;

    @Override
    public ImageUrlResponse upload(MultipartHttpServletRequest request) throws IOException {
        Path path = Path.of(Constants.UPLOAD_PATH);
        createDirectoryIfNotExists(path);

        MultipartFile file = request.getFile("file");
        validateFile(file);

        final String generatedName = BaseUtils.generateUniqueString(15) + ".webp";
        final String url = Constants.UPLOAD_PATH + File.separator + generatedName;
        File img = new File(url);
        Files.copy(file.getInputStream(), img.toPath(), StandardCopyOption.REPLACE_EXISTING);

        Image image = saveImageOutPort.save(Image.builder()
                .id(UUID.randomUUID())
                .path(url)
                .name(generatedName)
                .originalName(file.getOriginalFilename())
                .size(file.getSize())
                .build());
        return new ImageUrlResponse(image.getId(), Constants.FILE_VIEW_URL + image.getId());
    }

    private void createDirectoryIfNotExists(final Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    private void validateFile(final MultipartFile file) throws BadRequestException {
        if (file == null)
            throw new BadRequestException();
        if (file.getSize() > Constants.MAX_FILE_SIZE)
            throw new NotAcceptableException(ErrorMessages.MAX_FILE_SIZE);
    }
}
