package com.example.demo.domain.useCase.user;

import com.example.demo.domain.models.Book;

import java.util.Optional;

public interface BookGetByIdUseCase {

    Optional<Book> execute(int id);
}
