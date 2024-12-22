package com.example.demo.domain.useCase.user;

import com.example.demo.domain.models.Book;

import java.util.List;

public interface BookGetAllUseCase {

    List<Book> execute();

    List<Book> execute(int page, int size);
}
