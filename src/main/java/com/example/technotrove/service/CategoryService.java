package com.example.technotrove.service;

import com.example.technotrove.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.technotrove.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        System.out.println("Fetched Categories: " + categories); // Debug log
        return categories;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}


