package com.example.Bai9.input;

import java.util.List;

public record ProductInput(String title, Integer quantity, String desc, Double price,
        String userId, List<String> categoryIds) {
}
