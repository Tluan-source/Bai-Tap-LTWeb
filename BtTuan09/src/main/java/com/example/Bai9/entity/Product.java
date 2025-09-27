package com.example.Bai9.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.*;


@Entity @Table(name = "products")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Product {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String title;
private Integer quantity;


@Column(name = "description", columnDefinition = "NVARCHAR(2000)")
private String desc;


private BigDecimal price;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
private User user;


@ManyToMany
@JoinTable(name = "product_categories",
joinColumns = @JoinColumn(name = "product_id"),
inverseJoinColumns = @JoinColumn(name = "category_id"))
private Set<Category> categories = new HashSet<>();
}
