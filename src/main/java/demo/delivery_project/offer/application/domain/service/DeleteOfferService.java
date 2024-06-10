package demo.delivery_project.offer.application.domain.service;

import demo.delivery_project.offer.application.usecase.in.DeleteOfferUseCase;
import demo.delivery_project.offer.application.usecase.out.DeleteOfferOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteOfferService implements DeleteOfferUseCase {
    private final DeleteOfferOutPort deleteOfferOutPort;

    @Override
    public void delete(UUID id) {
        deleteOfferOutPort.delete(id);
    }
}
