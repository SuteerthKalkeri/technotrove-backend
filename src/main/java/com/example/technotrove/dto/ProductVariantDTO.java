package com.example.technotrove.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductVariantDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String sku;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    private String variantImage;
    private List<String> images;

    // Default Constructor
    public ProductVariantDTO() {}

    // Getters and Setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getVariantImage() {
        return variantImage;
    }

    public void setVariantImage(String variantImage) {
        this.variantImage = variantImage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
