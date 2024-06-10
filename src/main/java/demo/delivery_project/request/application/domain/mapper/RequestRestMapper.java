package demo.delivery_project.request.application.domain.mapper;

import demo.delivery_project.offer.application.domain.model.Offer;
import demo.delivery_project.offer.application.usecase.in.request.OfferCreateRequest;
import demo.delivery_project.offer.application.usecase.in.request.OfferUpdateRequest;
import demo.delivery_project.offer.application.usecase.in.response.OfferResponse;
import demo.delivery_project.product.application.domain.mapper.ProductRestMapper;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import demo.delivery_project.request.application.domain.model.Request;
import demo.delivery_project.request.application.usecase.in.request.RequestCreateRequest;
import demo.delivery_project.request.application.usecase.in.request.RequestUpdateRequest;
import demo.delivery_project.request.application.usecase.in.response.RequestResponse;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class RequestRestMapper {
    @Autowired
    GetProductOutPort getProductOutPort;

    @Autowired
    ProductRestMapper productRestMapper;

    @Mapping(target = "product", ignore = true)
    public abstract RequestResponse mapToResponse(Request domain);

    public abstract List<RequestResponse> mapToResponse(List<Request> domain);

    public abstract Request mapToDomain(RequestCreateRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Request mapToDomain(RequestUpdateRequest request, @MappingTarget Request domain);

    @AfterMapping
    public void afterMapping(@MappingTarget RequestResponse response, Request domain) {
        Product product = getProductOutPort.get(domain.getProductId());
        response.setProduct(productRestMapper.mapToResponse(product));
    }
}
