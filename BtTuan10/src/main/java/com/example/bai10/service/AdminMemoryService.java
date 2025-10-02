package com.example.bai10.service;

import com.example.bai10.dto.CategoryDTO;
import com.example.bai10.dto.ProductDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminMemoryService {
  private final List<String> categories = new ArrayList<>();
  private final List<ProductDTO> products = new ArrayList<>();

  public List<String> getCategories(){ return categories; }
  public void addCategory(CategoryDTO dto){ categories.add(dto.getName()); }

  public List<ProductDTO> getProducts(){ return products; }
  public void addProduct(ProductDTO dto){ products.add(dto); }
}
