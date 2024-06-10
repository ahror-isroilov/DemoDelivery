package demo.delivery_project.region.application.domain.service;

import demo.delivery_project.region.application.usecase.in.DeleteRegionUseCase;
import demo.delivery_project.region.application.usecase.out.DeleteRegionOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteRegionService implements DeleteRegionUseCase {
    private final DeleteRegionOutPort deleteRegionOutPort;

    @Override
    public void delete(UUID id) {
        deleteRegionOutPort.delete(id);
    }
}
