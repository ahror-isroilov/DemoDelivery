package demo.delivery_project.request.application.usecase.out;

import java.util.UUID;

public interface DeleteRequestOutPort {
    void delete(UUID id);
}
