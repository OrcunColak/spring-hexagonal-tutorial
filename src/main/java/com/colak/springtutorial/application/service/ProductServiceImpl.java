package com.colak.springtutorial.application.service;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.in.ProductUseCase;
import com.colak.springtutorial.domain.port.out.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// The service layer is responsible for interacting with the domain layer and serves as a bridge between adapters and
// the core logic.
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductUseCase {

    // ProductService relies on the ProductRepository port, which ensures that the domain logic remains independent from
    // database implementations.
    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);
    }
}

