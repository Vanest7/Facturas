package com.example.demo.domain.useCase.user.impl;

import com.example.demo.common.annotation.DomainTransactional;
import com.example.demo.common.annotation.DomainUseCase;
import com.example.demo.domain.services.BookService;
import com.example.demo.domain.useCase.user.BookCountUseCase;
import lombok.RequiredArgsConstructor;


@DomainUseCase
@DomainTransactional
@RequiredArgsConstructor
public class BookCountUseCaseImpl implements BookCountUseCase {

   private final BookService bookService;

    @Override
    public int execute() {
        return bookService.count();
    }
}
