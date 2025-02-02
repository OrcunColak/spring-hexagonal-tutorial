package com.colak.springtutorial.application.service;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.in.ProductService;
import com.colak.springtutorial.domain.port.out.ProductRepositoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// The service layer is responsible for interacting with the domain layer and serves as a bridge between adapters and
// the core logic.
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    // ProductService relies on the ProductRepositoryService , which ensures that the domain logic remains independent of
    // database implementations.
    private final ProductRepositoryService productRepositoryService;

    @Override
    public List<Product> getAllProducts() {
        return productRepositoryService.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepositoryService.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryService.save(product);
    }
}

