package demo.delivery_project.image.adapter.in.web.contract;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.UUID;

@RequestMapping("/image")
public interface ImageController {
    @PostMapping("/upload")
    ResponseEntity<?> upload(MultipartHttpServletRequest request) throws IOException, InterruptedException;

    @GetMapping("/view/{id}")
    public ResponseEntity<InputStreamResource> view(@PathVariable UUID id) throws IOException;
}
