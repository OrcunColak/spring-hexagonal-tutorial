package com.colak.springtutorial.adapters.inbound.api;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.in.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    // Adapter uses port
    private final ProductUseCase productUseCase;


    @GetMapping
    public List<Product> getAllProducts() {
        return productUseCase.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productUseCase.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productUseCase.createProduct(product);
    }
}

