package demo.delivery_project.image.application.domain.service;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.image.application.domain.model.Image;
import demo.delivery_project.image.application.usecase.in.response.ViewImageUseCase;
import demo.delivery_project.image.application.usecase.out.GetImageOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ViewImageService implements ViewImageUseCase {
    private final GetImageOutPort getImageOutPort;

    @Override
    public ResponseEntity<InputStreamResource> view(UUID id) throws FileNotFoundException {
        Image image = getImageOutPort.get(id);
        File file = new File(image.getPath());
        if (!file.exists())
            throw new DataNotFoundException(ErrorMessages.IMAGE_NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" + image.getOriginalName());

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        long contentLength = file.length();
        MediaType mediaType = MediaType.parseMediaType("image/webp");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(contentLength)
                .contentType(mediaType)
                .body(resource);
    }
}
