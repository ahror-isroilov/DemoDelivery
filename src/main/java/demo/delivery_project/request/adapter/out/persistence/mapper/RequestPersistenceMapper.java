package demo.delivery_project.request.adapter.out.persistence.mapper;

import demo.delivery_project.offer.adapter.out.persistence.entity.OfferJpaEntity;
import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.request.adapter.out.persistence.entity.RequestJpaEntity;
import demo.delivery_project.request.application.domain.model.Request;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestPersistenceMapper {
    Request mapToDomain(RequestJpaEntity entity);

    List<Request> mapToDomain(List<RequestJpaEntity> entities);

    RequestJpaEntity mapToEntity(Request domain);

    List<RequestJpaEntity> mapToEntity(List<Request> domain);
}
