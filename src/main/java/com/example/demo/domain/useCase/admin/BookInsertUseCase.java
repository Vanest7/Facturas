package com.example.demo.domain.useCase.admin;

import com.example.demo.domain.models.Book;

public interface BookInsertUseCase {

    int execute(Book book);
}
