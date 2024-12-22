package com.example.demo.domain.useCase.user.impl;

import com.example.demo.common.annotation.DomainTransactional;
import com.example.demo.common.annotation.DomainUseCase;
import com.example.demo.domain.models.Book;
import com.example.demo.domain.services.BookService;
import com.example.demo.domain.useCase.user.BookGetAllUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookGetAllUseCaseImpl implements BookGetAllUseCase {

    private final BookService bookService;

    @Override
    public List<Book> execute() {
        return bookService.getAll();
    }

    @Override
    public List<Book> execute(int page, int size) {
        return bookService.getAll(page, size);
    }
}
