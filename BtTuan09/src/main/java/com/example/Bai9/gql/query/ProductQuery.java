package com.example.Bai9.gql.query;

import com.example.Bai9.entity.Product;
import com.example.Bai9.repo.ProductRepository;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.*;


@Controller
public class ProductQuery {
private final ProductRepository productRepo;
public ProductQuery(ProductRepository productRepo){ this.productRepo = productRepo; }


@QueryMapping
public List<Product> productsSortedByPriceAsc(){
return productRepo.findAllByOrderByPriceAsc();
}


@QueryMapping
public List<Product> productsByCategory(@Argument Long categoryId){
return productRepo.findByCategoryId(categoryId);
}
}
