package com.example.technotrove.service;

import com.example.technotrove.dto.ProductDTO;
import com.example.technotrove.dto.ProductVariantDTO;
import com.example.technotrove.model.Product;
import com.example.technotrove.model.ProductVariant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.example.technotrove.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional(readOnly = true)
    @Cacheable(value = "products")
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToProductDTO).toList();
    }

    @Cacheable(value = "productDetails", key = "#id")
    public Optional<ProductDTO> getProductDetails(Long id) {
        Optional<Product> productOptional = productRepository.findByIdWithVariants(id);
        return productOptional.map(this::convertToProductDTO);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrimaryImage(product.getPrimaryImage());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(product.getCategory());

        List<ProductVariantDTO> productVariantDTOList = new ArrayList<>();
        for (ProductVariant productVariant : product.getProductVariants()) {
            ProductVariantDTO productVariantDTO = new ProductVariantDTO();
            productVariantDTO.setName(productVariant.getName());
            productVariantDTO.setImages(listAsString(productVariant.getImages()));
            productVariantDTO.setPrice(productVariant.getPrice());
            productVariantDTO.setQuantity(productVariant.getQuantity());
            productVariantDTO.setVariantImage(productVariant.getVariantImage());
            productVariantDTO.setSku(productVariant.getSku());
            productVariantDTOList.add(productVariantDTO);
        }

        productDTO.setProductVariants(productVariantDTOList);
        return productDTO;
    }

    private List<String> listAsString(List<String> images) {
        try {
            return Collections.singletonList(objectMapper.writeValueAsString(images));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

