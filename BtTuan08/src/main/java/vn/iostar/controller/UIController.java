package vn.iostar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping("/admin/categories/index")
    public String indexCategories() {
        return "admin/categories/index";
    }
    @GetMapping("/admin/product/index")
    public String indexProducts() {
        return "admin/product/index";
    }
}
