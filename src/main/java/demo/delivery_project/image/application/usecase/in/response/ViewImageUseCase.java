package demo.delivery_project.image.application.usecase.in.response;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.util.UUID;

public interface ViewImageUseCase {
    ResponseEntity<InputStreamResource> view(UUID id) throws FileNotFoundException;
}
