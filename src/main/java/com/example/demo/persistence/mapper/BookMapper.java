package com.example.demo.persistence.mapper;

import com.example.demo.common.locale.LanguageUtils;
import com.example.demo.domain.models.Book;

import com.example.demo.persistence.mapper.common.CustomRowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements CustomRowMapper<Book> {

    private final PublisherRowMapper publisherRowMapper = new PublisherRowMapper();
    private final CategoryRowMapper categoryRowMapper = new CategoryRowMapper();


    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
    String language = LanguageUtils.getCurrentLocale();
    Book book = new Book();
    book.setId(rs.getInt("books.id"));
    book.setIsbn(rs.getString("books.isbn"));
    book.setCover(rs.getString("books.cover"));
    book.setSynopsis(rs.getString("books.synopsis_"+language));
    book.setTitle(rs.getString("books.title_"+language));
    book.setPrice(rs.getBigDecimal("books.price"));
    book.setDiscount(rs.getFloat(("books.discount")));
    if(this.existsColumn(rs, "publishers_id")) {
        book.setPublisher(publisherRowMapper.mapRow(rs, rowNum));
    }
    if(this.existsColumn(rs, "categories_id")) {
        book.setCategory(categoryRowMapper.mapRow(rs, rowNum));
    }
    return book;
}


}
