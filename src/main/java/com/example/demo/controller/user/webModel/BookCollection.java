package com.example.demo.controller.user.webModel;

import java.math.BigDecimal;

public record BookCollection(
        String isbn,
        String title,
        String synopsis,
        BigDecimal price,
        float discount,
        String cover
) {
}
