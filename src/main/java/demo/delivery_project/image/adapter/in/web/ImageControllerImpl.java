package demo.delivery_project.image.adapter.in.web;

import demo.delivery_project.image.adapter.in.web.contract.ImageController;
import demo.delivery_project.image.application.usecase.in.response.ImageUrlResponse;
import demo.delivery_project.image.application.usecase.in.response.UploadImageUseCase;
import demo.delivery_project.image.application.usecase.in.response.ViewImageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ImageControllerImpl implements ImageController {
    private final UploadImageUseCase upload;
    private final ViewImageUseCase view;

    @Override
    public ResponseEntity<?> upload(MultipartHttpServletRequest request) throws IOException, InterruptedException {
        ImageUrlResponse response = upload.upload(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<InputStreamResource> view(UUID id) throws IOException {
        return view.view(id);
    }
}
