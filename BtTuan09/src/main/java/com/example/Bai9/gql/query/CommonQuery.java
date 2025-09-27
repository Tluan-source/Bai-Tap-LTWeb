package com.example.Bai9.gql.query;

import com.example.Bai9.entity.*;
import com.example.Bai9.repo.*;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.*;


@Controller
public class CommonQuery {
private final UserRepository userRepo;
private final CategoryRepository catRepo;
private final ProductRepository prodRepo;


public CommonQuery(UserRepository u, CategoryRepository c, ProductRepository p){
this.userRepo = u; this.catRepo = c; this.prodRepo = p;
}


@QueryMapping public List<User> users(){ return userRepo.findAll(); }
@QueryMapping public List<Category> categories(){ return catRepo.findAll(); }
@QueryMapping public List<Product> products(){ return prodRepo.findAll(); }
}
