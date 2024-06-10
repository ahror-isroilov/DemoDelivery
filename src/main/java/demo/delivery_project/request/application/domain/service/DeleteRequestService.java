package demo.delivery_project.request.application.domain.service;

import demo.delivery_project.offer.application.usecase.in.DeleteOfferUseCase;
import demo.delivery_project.offer.application.usecase.out.DeleteOfferOutPort;
import demo.delivery_project.request.application.usecase.in.DeleteRequestUseCase;
import demo.delivery_project.request.application.usecase.out.DeleteRequestOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteRequestService implements DeleteRequestUseCase {
    private final DeleteRequestOutPort deleteOfferOutPort;

    @Override
    public void delete(UUID id) {
        deleteOfferOutPort.delete(id);
    }
}
