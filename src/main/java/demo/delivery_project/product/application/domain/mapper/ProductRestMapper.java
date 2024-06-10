package demo.delivery_project.product.application.domain.mapper;

import demo.delivery_project.common.constant.Constants;
import demo.delivery_project.image.application.domain.mapper.ImageRestMapper;
import demo.delivery_project.image.application.domain.model.Image;
import demo.delivery_project.image.application.usecase.in.response.ImageUrlResponse;
import demo.delivery_project.image.application.usecase.out.GetImageOutPort;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.in.request.ProductCreateRequest;
import demo.delivery_project.product.application.usecase.in.request.ProductUpdateRequest;
import demo.delivery_project.product.application.usecase.in.response.ProductResponse;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductRestMapper {
    @Autowired
    GetImageOutPort getImageOutPort;

    public abstract Product mapToDomain(ProductCreateRequest request);

    @Mapping(target = "image", ignore = true)
    public abstract ProductResponse mapToResponse(Product domain);

    public abstract List<ProductResponse> mapToResponse(List<Product> domains);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract Product mapToDomain(ProductUpdateRequest request, @MappingTarget Product domain);

    @AfterMapping
    public void after(@MappingTarget ProductResponse response, Product domain) {
        Image image = getImageOutPort.get(domain.getImageId());
        response.setImage(new ImageUrlResponse(image.getId(), Constants.FILE_VIEW_URL + image.getId()));
    }
}
