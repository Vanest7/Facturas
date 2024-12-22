package com.example.demo.domain.services;

import com.example.demo.domain.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAll();

    List<Book> getAll(int page, int size);

    Optional<Book> findById(int id);

    void deleteBookById(int id);

    int count();

    int insertBook(Book book);
}
