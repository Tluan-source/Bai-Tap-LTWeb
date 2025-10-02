package com.example.bai10.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
public class CategoryDTO {
  @NotBlank(message="Tên danh mục không được trống")
  @Size(max=50, message="Tên tối đa 50 ký tự")
  private String name;
  // getter/setter
  public String getName(){ return name; }
  public void setName(String name){ this.name = name; }
}
