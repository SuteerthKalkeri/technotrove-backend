package com.example.technotrove.repository;

import com.example.technotrove.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
