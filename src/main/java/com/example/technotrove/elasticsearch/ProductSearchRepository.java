package com.example.technotrove.elasticsearch;

import com.example.technotrove.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<Product, Long> {
    // Custom query to search products by name or description
    List<Product> findByNameContainingOrDescriptionContaining(String name, String description);
}
