package com.example.demo.persistence.dao.impl;

import com.example.demo.domain.models.Book;
import com.example.demo.persistence.dao.BookDaoDb;
import com.example.demo.persistence.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BookDaoDbJdbc implements BookDaoDb {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getAll() {
        String sql = """
                SELECT * FROM books
                """;
        return jdbcTemplate.query(sql, new BookMapper());
    }

    @Override
    public List<Book> getAll(int page, int size) {
        String sql = """
                SELECT * FROM books
                LIMIT ? OFFSET ?    
                """;
        return jdbcTemplate.query(sql, new BookMapper(), size,  page*size);

    }

    @Override
    public Optional<Book> findById(int id) {
        String sql = """
                SELECT * FROM books
                LEFT JOIN categories ON books.category_id = categories.id
                LEFT JOIN publishers ON books.publisher_id = publishers.id
                WHERE books.id = ?
           """;
        try{
            Book book = jdbcTemplate.queryForObject(sql, new BookMapper(), id);
            return Optional.of(book);
        }catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    @Override
    public void deleteBookById(int id) {
       String sql = """
               DELETE FROM books 
               WHERE books.id = ?
               """;

        jdbcTemplate.update(sql, id);
    }

    @Override
    public int count() {
        String sql = """
                    SELECT COUNT(*) FROM books
                """;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public int insert(Book book) {
        String sql = """
                    INSERT INTO books(
                      isbn, 
                      title_es, 
                      title_en, 
                      synopsis_es, 
                      synopsis_en, 
                      price, 
                      discount, 
                      cover, 
                      publisher_id, 
                      category_id)
                    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getTitle());
            ps.setString(4, book.getSynopsis());
            ps.setString(5, book.getSynopsis());
            ps.setBigDecimal(6, book.getPrice());
            ps.setFloat(7, book.getDiscount());
            ps.setString(8, book.getCover());
            ps.setLong(9, book.getPublisher().getId());
            ps.setLong(10, book.getCategory().getId());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

}
