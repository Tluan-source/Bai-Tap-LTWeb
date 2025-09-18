package com.example.baitap6.controller;

import java.util.Date;
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

import com.example.baitap6.entity.AppUser;
import com.example.baitap6.service.UserService;

@Controller
@RequestMapping("admin/users")
public class UserAdminController {
    
    @Autowired
    UserService userService;

    @GetMapping("add")
    public String add(ModelMap model) {
        model.addAttribute("user", new AppUser());
        return "admin/users/add";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @ModelAttribute("user") AppUser user) {
        if (user.getCreateDate() == null) {
            user.setCreateDate(new Date());
        }
        if (user.getIsAdmin() == null) {
            user.setIsAdmin(false);
        }
        if (user.getIsActive() == null) {
            user.setIsActive(true);
        }
        userService.save(user);
        model.addAttribute("message", "User is saved!");
        return new ModelAndView("redirect:/admin/users", model);
    }

    @RequestMapping("")
    public String list(ModelMap model) {
        List<AppUser> list = userService.findAll();
        model.addAttribute("users", list);
        return "admin/users/list";
    }

    @GetMapping("edit/{userId}")
    public String edit(ModelMap model, @PathVariable("userId") int userId) {
        Optional<AppUser> opt = userService.findById(userId);
        if (opt.isPresent()) {
            model.addAttribute("user", opt.get());
        } else {
            model.addAttribute("user", new AppUser());
        }
        return "admin/users/add";
    }

    @GetMapping("delete/{userId}")
    public ModelAndView delete(ModelMap model, @PathVariable("userId") int userId) {
        userService.deleteById(userId);
        model.addAttribute("message", "User is deleted!");
        return new ModelAndView("redirect:/admin/users", model);
    }

    @RequestMapping("search")
    public String search(ModelMap model, @RequestParam(name="keyword", required = false) String keyword) {
        List<AppUser> list = null;
        if (StringUtils.hasText(keyword)) {
            list = userService.findByUsernameContaining(keyword);
            list.addAll(userService.findByFullnameContaining(keyword));
            list.addAll(userService.findByEmailContaining(keyword));
        } else {
            list = userService.findAll();
        }
        model.addAttribute("users", list);
        return "admin/users/search";
    }
}
