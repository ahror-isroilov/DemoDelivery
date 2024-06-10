package demo.delivery_project.product.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.product.adapter.out.persistence.entity.ProductJpaEntity;
import demo.delivery_project.product.adapter.out.persistence.mapper.ProductPersistenceMapper;
import demo.delivery_project.product.adapter.out.persistence.repository.ProductJpaRepository;
import demo.delivery_project.product.application.domain.model.Product;
import demo.delivery_project.product.application.usecase.out.DeleteProductOutPort;
import demo.delivery_project.product.application.usecase.out.GetProductOutPort;
import demo.delivery_project.product.application.usecase.out.SaveProductOutPort;
import demo.delivery_project.product.application.usecase.out.UpdateProductOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductOutPort, GetProductOutPort, UpdateProductOutPort, DeleteProductOutPort {
    private final ProductJpaRepository productJpaRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product save(Product domain) {
        ProductJpaEntity entity = productJpaRepository.save(productPersistenceMapper.mapToEntity(domain));
        return productPersistenceMapper.mapToDomain(entity);
    }

    @Override
    public Product get(UUID id) {
        ProductJpaEntity productJpa = productJpaRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
        return productPersistenceMapper.mapToDomain(productJpa);
    }

    @Override
    public List<Product> getAll(Pageable pageable) {
        Page<ProductJpaEntity> all = productJpaRepository.findAll(pageable);
        return productPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public List<Product> getAllByOwner(UUID ownerId, Pageable pageable) {
        Page<ProductJpaEntity> all = productJpaRepository.getAllByCreatedBy(ownerId, pageable);
        return productPersistenceMapper.mapToDomain(all.getContent());
    }

    @Override
    public Boolean existsByOwnerAndName(UUID ownerId, String name) {
        return productJpaRepository.existsByCreatedByAndName(ownerId, name);
    }

    @Override
    public Boolean existsById(UUID id) {
        return productJpaRepository.existsById(id);
    }

    @Override
    public Boolean existsByOwnerAndCode(UUID ownerId, String code) {
        return productJpaRepository.existsByCreatedByAndCode(ownerId, code);
    }

    @Override
    public Product update(Product domain) {
        return save(domain);
    }

    @Override
    public void delete(UUID id) {
        productJpaRepository.deleteById(id);
    }
}
