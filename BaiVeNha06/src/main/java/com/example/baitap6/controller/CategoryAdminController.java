package com.example.baitap6.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.baitap6.entity.Category;
import com.example.baitap6.service.CategoryService;

@Controller
@RequestMapping("admin/categories")
public class CategoryAdminController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("category", new Category());
        return "admin/categories/add";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @ModelAttribute("category") Category category) {
        categoryService.save(category);
        model.addAttribute("message", "Category is saved!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @RequestMapping("")
    public String list(ModelMap model) {
        List<Category> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "admin/categories/list";
    }

    @GetMapping("edit/{categoryId}")
    public String edit(ModelMap model, @PathVariable("categoryId") int categoryId) {
        Optional<Category> opt = categoryService.findById(categoryId);
        if (opt.isPresent()) {
            model.addAttribute("category", opt.get());
        } else {
            model.addAttribute("category", new Category());
        }
        return "admin/categories/add";
    }

    @GetMapping("delete/{categoryId}")
    public ModelAndView delete(ModelMap model, @PathVariable("categoryId") int categoryId) {
        categoryService.deleteById(categoryId);
        model.addAttribute("message", "Category is deleted!");
        return new ModelAndView("redirect:/admin/categories", model);
    }

    @RequestMapping("search")
    public String search(ModelMap model, @RequestParam(name="name", required = false) String name) {
        List<Category> list = null;
        if (StringUtils.hasText(name)) {
            list = categoryService.findByCategoryNameContaining(name);
        } else {
            list = categoryService.findAll();
        }
        model.addAttribute("categories", list);
        return "admin/categories/search";
    }
}
