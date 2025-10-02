package com.example.bai10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {
  @GetMapping("/user")
  public String userHome(){ return "user/home"; }
}
