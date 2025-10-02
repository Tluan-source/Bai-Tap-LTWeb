package com.example.bai10.controller;

import com.example.bai10.dto.CategoryDTO;
import com.example.bai10.dto.ProductDTO;
import com.example.bai10.service.AdminMemoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
  private final AdminMemoryService svc;
  public AdminController(AdminMemoryService svc){ this.svc = svc; }

  @GetMapping("/admin")
  public String adminHome(){ return "admin/home"; }

  @GetMapping("/admin/category")
  public String categoryPage(Model model){
    model.addAttribute("items", svc.getCategories());
    model.addAttribute("categoryDTO", new CategoryDTO());
    return "admin/category";
  }

  @PostMapping("/admin/category")
  public String addCategory(@Valid @ModelAttribute("categoryDTO") CategoryDTO dto,
                            BindingResult br, Model model){
    if (br.hasErrors()){
      model.addAttribute("items", svc.getCategories());
      return "admin/category";
    }
    svc.addCategory(dto);
    return "redirect:/admin/category";
  }

  @GetMapping("/admin/product")
  public String productPage(Model model){
    model.addAttribute("items", svc.getProducts());
    model.addAttribute("productDTO", new ProductDTO());
    return "admin/product";
  }

  @PostMapping("/admin/product")
  public String addProduct(@Valid @ModelAttribute("productDTO") ProductDTO dto,
                           BindingResult br, Model model){
    if (br.hasErrors()){
      model.addAttribute("items", svc.getProducts());
      return "admin/product";
    }
    svc.addProduct(dto);
    return "redirect:/admin/product";
  }
}