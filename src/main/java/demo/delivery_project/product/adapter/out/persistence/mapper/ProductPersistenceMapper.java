package demo.delivery_project.product.adapter.out.persistence.mapper;

import demo.delivery_project.product.adapter.out.persistence.entity.ProductJpaEntity;
import demo.delivery_project.product.application.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {
    Product mapToDomain(ProductJpaEntity entity);

    List<Product> mapToDomain(List<ProductJpaEntity> entities);

    ProductJpaEntity mapToEntity(Product domain);

    List<ProductJpaEntity> mapToEntity(List<Product> domains);
}
