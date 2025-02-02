package com.colak.springtutorial.adapters.inbound.api;

import com.colak.springtutorial.domain.model.Product;
import com.colak.springtutorial.domain.port.in.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// The in adapter serves as the entry point to interact with the domain logic.
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    // Adapter uses port
    private final ProductService productService;


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}

