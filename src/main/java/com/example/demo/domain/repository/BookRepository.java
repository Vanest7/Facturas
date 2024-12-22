package com.example.demo.domain.repository;


import com.example.demo.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> getAll();

    List<Book> getAll(int page, int size);

    Optional<Book> findById(int id);

    void deleteBookById(int id);

    int count();

    int insert(Book book);
}
