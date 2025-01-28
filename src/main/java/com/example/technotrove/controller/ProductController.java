package com.example.technotrove.controller;

import com.example.technotrove.dto.ProductDTO;
import com.example.technotrove.model.Product;
import com.example.technotrove.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.technotrove.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private RandomService randomService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

   // @GetMapping("/{id}")
   // public ResponseEntity<Product> getProductById(@PathVariable Long id) {
   //     return productService.getProductById(id)
    //            .map(ResponseEntity::ok)
   //             .orElse(ResponseEntity.notFound().build());
   // }

    @GetMapping(params = "id")
    public ResponseEntity<ProductDTO> getProductDetails(@RequestParam Long id) {
        return productService.getProductDetails(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.createProduct(product);
//    }
}
