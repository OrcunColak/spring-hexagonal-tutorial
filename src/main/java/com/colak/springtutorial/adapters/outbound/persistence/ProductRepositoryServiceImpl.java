package com.colak.springtutorial.adapters.outbound.persistence;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.out.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// The out adapter is responsible for the implementation of the persistence logic.
@Component
@RequiredArgsConstructor
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id)
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()));
    }

    @Transactional
    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.getId(), product.getName(), product.getPrice());
        ProductEntity savedEntity = productRepository.save(entity);
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice());
    }
}

