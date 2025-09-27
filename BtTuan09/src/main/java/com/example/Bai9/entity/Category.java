package com.example.Bai9.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@Entity @Table(name = "categories")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Category {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;
private String images;


@ManyToMany(mappedBy = "categories")
private Set<User> users = new HashSet<>();


@ManyToMany(mappedBy = "categories")
private Set<Product> products = new HashSet<>();
}
