package com.colak.springtutorial.domain.port.out;

import com.colak.springtutorial.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
}
