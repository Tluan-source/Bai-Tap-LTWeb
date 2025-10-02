package com.example.bai10.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDTO {
  @NotBlank(message="Tên sản phẩm không được trống")
  private String name;

  @Positive(message="Giá phải > 0")
  private double price;

  @NotBlank(message="Danh mục không được trống")
  private String category; // lưu text đơn giản

  // getter/setter
  public String getName(){ return name; }
  public void setName(String name){ this.name = name; }
  public double getPrice(){ return price; }
  public void setPrice(double price){ this.price = price; }
  public String getCategory(){ return category; }
  public void setCategory(String category){ this.category = category; }
}
