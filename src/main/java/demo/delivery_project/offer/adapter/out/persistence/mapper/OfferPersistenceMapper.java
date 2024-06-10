package demo.delivery_project.offer.adapter.out.persistence.mapper;

import demo.delivery_project.offer.adapter.out.persistence.entity.OfferJpaEntity;
import demo.delivery_project.offer.application.domain.model.Offer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfferPersistenceMapper {
    Offer mapToDomain(OfferJpaEntity entity);

    List<Offer> mapToDomain(List<OfferJpaEntity> entities);

    OfferJpaEntity mapToEntity(Offer domain);

    List<OfferJpaEntity> mapToEntity(List<Offer> domain);
}
