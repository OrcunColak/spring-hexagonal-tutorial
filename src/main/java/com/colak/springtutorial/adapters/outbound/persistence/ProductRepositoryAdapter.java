package com.colak.springtutorial.adapters.outbound.persistence;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream()
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id)
                .map(entity -> new Product(entity.getId(), entity.getName(), entity.getPrice()));
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = new ProductEntity(product.getId(), product.getName(), product.getPrice());
        ProductEntity savedEntity = productRepository.save(entity);
        return new Product(savedEntity.getId(), savedEntity.getName(), savedEntity.getPrice());
    }
}

