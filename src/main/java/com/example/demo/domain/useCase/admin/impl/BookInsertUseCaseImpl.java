package com.example.demo.domain.useCase.admin.impl;

import com.example.demo.common.annotation.DomainTransactional;
import com.example.demo.common.annotation.DomainUseCase;
import com.example.demo.domain.models.Book;
import com.example.demo.domain.services.BookService;
import com.example.demo.domain.useCase.admin.BookInsertUseCase;
import lombok.RequiredArgsConstructor;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookInsertUseCaseImpl implements BookInsertUseCase {

    private final BookService bookService;

    @Override
    public int execute(Book book) {
        return bookService.insertBook(book);
    }
}
