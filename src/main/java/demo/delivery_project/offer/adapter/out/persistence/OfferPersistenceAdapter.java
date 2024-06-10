package demo.delivery_project.offer.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.offer.adapter.out.persistence.entity.OfferJpaEntity;
import demo.delivery_project.offer.adapter.out.persistence.mapper.OfferPersistenceMapper;
import demo.delivery_project.offer.adapter.out.persistence.repository.OfferJpaRepository;
import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.offer.application.usecase.out.DeleteOfferOutPort;
import demo.delivery_project.offer.application.usecase.out.GetOfferOutPort;
import demo.delivery_project.offer.application.usecase.out.SaveOfferOutPort;
import demo.delivery_project.offer.application.usecase.out.UpdateOfferOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferPersistenceAdapter implements SaveOfferOutPort, GetOfferOutPort, UpdateOfferOutPort, DeleteOfferOutPort {
    private final OfferJpaRepository offerJpaRepository;
    private final OfferPersistenceMapper offerPersistenceMapper;

    @Override
    public Offer save(Offer domain) {
        OfferJpaEntity entity = offerPersistenceMapper.mapToEntity(domain);
        OfferJpaEntity saved = offerJpaRepository.save(entity);
        return offerPersistenceMapper.mapToDomain(saved);
    }

    @Override
    public Offer update(Offer domain) {
        return save(domain);
    }

    @Override
    public Offer get(UUID id) {
        OfferJpaEntity entity = offerJpaRepository.findById(id).orElseThrow(() -> new DataNotFoundException(ErrorMessages.OFFER_NOT_FOUND));
        return offerPersistenceMapper.mapToDomain(entity);
    }

    @Override
    public Boolean existsByCode(String code) {
        return offerJpaRepository.existsByCode(code);
    }

    @Override
    public List<Offer> getAll(Pageable pageable) {
        Page<OfferJpaEntity> all = offerJpaRepository.findAll(pageable);
        return offerPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public List<Offer> getAllByOwner(UUID ownerId, Pageable pageable) {
        Page<OfferJpaEntity> all = offerJpaRepository.findAllByCreatedBy(ownerId, pageable);
        return offerPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public Offer getByCode(String code) {
        return offerPersistenceMapper.mapToDomain(
                offerJpaRepository.getByCode(code).orElseThrow(() -> new DataNotFoundException(ErrorMessages.OFFER_NOT_FOUND))
        );
    }

    @Override
    public void delete(UUID id) {
        offerJpaRepository.deleteById(id);
    }
}
