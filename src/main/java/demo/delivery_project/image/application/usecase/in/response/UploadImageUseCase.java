package demo.delivery_project.image.application.usecase.in.response;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

public interface UploadImageUseCase {
    ImageUrlResponse upload(MultipartHttpServletRequest request) throws IOException;
}
