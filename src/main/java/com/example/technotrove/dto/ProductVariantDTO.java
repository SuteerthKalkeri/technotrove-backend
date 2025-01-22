package com.example.technotrove.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductVariantDTO implements Serializable {
    private String sku;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String variantImage;
    private List<String> images;

    // Constructor, Getters, and Setters
    public ProductVariantDTO(String sku, String name, BigDecimal price, Integer quantity, String variantImage, List<String> images) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.variantImage = variantImage;
        this.images = images;
    }
}

