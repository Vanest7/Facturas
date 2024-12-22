package com.example.demo.controller.user.webModel;

import com.example.demo.domain.models.Category;
import com.example.demo.domain.models.Genre;

import java.math.BigDecimal;
import java.util.List;

public record BookDetail(
        String isbn,
        String title,
        BigDecimal price,
        float discount,
        String synopsis,
        String cover,
        List<Genre> genres,
        Category category
) {


}

