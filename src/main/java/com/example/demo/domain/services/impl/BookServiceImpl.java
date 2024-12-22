package com.example.demo.domain.services.impl;

import com.example.demo.common.annotation.DomainService;
import com.example.demo.domain.models.Book;
import com.example.demo.domain.repository.BookRepository;
import com.example.demo.domain.services.BookService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@DomainService
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

private final BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public List<Book> getAll(int page, int size) {
        return bookRepository.getAll(page, size);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteBookById(id);
    }

    @Override
    public int count() {
        return bookRepository.count();
    }

    @Override
    public int insertBook(Book book) {
        return bookRepository.insert(book);
    }
}
