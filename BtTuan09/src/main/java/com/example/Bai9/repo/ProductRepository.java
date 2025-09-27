package com.example.Bai9.repo;


import org.springframework.data.jpa.repository.*;

import com.example.Bai9.entity.Product;

import java.util.*;


public interface ProductRepository extends JpaRepository<Product, Long> {
List<Product> findAllByOrderByPriceAsc();
@Query("select p from Product p join p.categories c where c.id = :categoryId")
List<Product> findByCategoryId(Long categoryId);
}
