package com.example.demo.persistence.mapper;

import com.example.demo.domain.models.Category;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("books.id"));
        category.setName_es(rs.getString("books.title_es"));
        category.setSlug(rs.getString("categories.slug"));
        return category;
    }
}
