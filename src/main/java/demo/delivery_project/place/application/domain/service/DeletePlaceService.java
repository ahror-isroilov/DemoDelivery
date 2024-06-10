package demo.delivery_project.place.application.domain.service;

import demo.delivery_project.place.application.usecase.in.DeletePlaceUseCase;
import demo.delivery_project.place.application.usecase.out.DeletePlaceOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletePlaceService implements DeletePlaceUseCase {
    private final DeletePlaceOutPort deletePlaceOutPort;

    @Override
    public void delete(UUID id) {
        deletePlaceOutPort.delete(id);
    }
}
