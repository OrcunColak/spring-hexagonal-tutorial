package com.colak.springtutorial.adapters.inbound.api;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.in.ProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// The in adapter serves as the entry point to interact with the domain logic.
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    // Adapter uses port
    private final ProductServicePort productServicePort;


    @GetMapping
    public List<Product> getAllProducts() {
        return productServicePort.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productServicePort.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productServicePort.createProduct(product);
    }
}

