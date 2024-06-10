package demo.delivery_project.offer.application.domain.mapper;

import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.product.application.domain.mapper.ProductRestMapper;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OfferRestMapper {
    @Autowired
    GetProductOutPort getProductOutPort;

    @Autowired
    ProductRestMapper productRestMapper;

    @Mapping(target = "product", ignore = true)
    public abstract OfferResponse mapToResponse(Offer domain);

    public abstract List<OfferResponse> mapToResponse(List<Offer> domain);

    public abstract Offer mapToDomain(OfferCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Offer mapToDomain(OfferUpdateRequest request, @MappingTarget Offer domain);

    @AfterMapping
    public void afterMapping(@MappingTarget OfferResponse response, Offer domain) {
        Product product = getProductOutPort.get(domain.getProductId());
        response.setProduct(productRestMapper.mapToResponse(product));
    }
}
