package com.example.demo.domain.useCase.user.impl;

import com.example.demo.common.annotation.DomainTransactional;
import com.example.demo.common.annotation.DomainUseCase;
import com.example.demo.domain.models.Book;
import com.example.demo.domain.services.BookService;
import com.example.demo.domain.useCase.user.BookGetByIdUseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookGetByIdUseCaseImpl implements BookGetByIdUseCase {

    private final BookService bookService;

    @Override
    public Optional<Book> execute(int id) {
        return bookService.findById(id);
    }
}
