package com.example.demo.domain.useCase.user.impl;

import com.example.demo.common.annotation.DomainUseCase;
import com.example.demo.common.exception.ResourceNotFoundException;
import com.example.demo.domain.services.BookService;
import com.example.demo.domain.useCase.user.BookDeleteByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@DomainUseCase
@Transactional
@RequiredArgsConstructor
public class BookDeleteByIdUseCaseImpl implements BookDeleteByIdUseCase {

    private final BookService bookService;

    @Override
    public void execute(int id) {
        bookService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book not found")) ;
        bookService.deleteBookById(id);
    }
}
