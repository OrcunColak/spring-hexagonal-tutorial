package com.colak.springtutorial.domain.port.in;

import com.colak.springtutorial.domain.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
}

