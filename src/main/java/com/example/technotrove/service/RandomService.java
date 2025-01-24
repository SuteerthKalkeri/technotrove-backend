package com.example.technotrove.service;


import com.example.technotrove.dto.ProductDTO;
import com.example.technotrove.model.Product;
import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RandomService {

    @Autowired
    private ProductService productService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Cacheable(value = "a")
    public List<ProductDTO> getAllProducts() {

//        String redisKey = "asd";
//        Object cachedProduct = (Object) redisTemplate.opsForValue().get(redisKey);


        List<ProductDTO> list =  productService.getAllProducts();

        return list;
    }


}
