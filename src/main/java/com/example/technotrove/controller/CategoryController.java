package com.example.technotrove.controller;

import com.example.technotrove.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.technotrove.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        System.out.println("Controller Layer: Returning Categories: " + categories); // Debug log
        return categories;
    }

//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
//        Category createdCategory = categoryService.createCategory(category);
//        return ResponseEntity.ok(createdCategory);
//    }

}

