package com.example.technotrove.service;

import com.example.technotrove.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.technotrove.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // public Optional<Product> getProductById(Long id) {
    //    return productRepository.findById(id);
    // }

    public Optional<Product> getProductDetails(Long id) {
        return productRepository.findByIdWithVariants(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}