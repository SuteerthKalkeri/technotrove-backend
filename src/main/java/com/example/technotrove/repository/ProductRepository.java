package com.example.technotrove.repository;

import com.example.technotrove.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.productVariants WHERE p.id = :id")
    Optional<Product> findByIdWithVariants(Long id);

}
