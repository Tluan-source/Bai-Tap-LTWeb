package vn.iostar.service;


import vn.iostar.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface CategoryService {
    //BT7
//    Page<Category> search(String keyword, Pageable pageable);
//    Category save(Category c);
    Optional<Category> findById(Long id);
//    void deleteById(Long id);

    //BT8
    Category createCategory(Category category);
    Category updateCategory(Long id,Category category);
    void deleteCategory(Long id);
    List<Category> findAll();
    List<Category> findByName(String name);
    Page<Category> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Category> findAll(Pageable pageable);
}
