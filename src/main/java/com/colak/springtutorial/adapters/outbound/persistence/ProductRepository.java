package com.colak.springtutorial.adapters.outbound.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}

