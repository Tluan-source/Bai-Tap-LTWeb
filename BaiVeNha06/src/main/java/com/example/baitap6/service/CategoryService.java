package com.example.baitap6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.baitap6.entity.Category;

public interface CategoryService {
    
    List<Category> findAll();
    
    Optional<Category> findById(Integer id);
    
    Category save(Category category);
    
    void deleteById(Integer id);
    
    List<Category> findByCategoryNameContaining(String name);
    
    Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
}
