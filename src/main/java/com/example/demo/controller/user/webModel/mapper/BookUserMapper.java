package com.example.demo.controller.user.webModel.mapper;

import com.example.demo.common.annotation.Mapper;
import com.example.demo.controller.user.webModel.BookCollection;
import com.example.demo.controller.user.webModel.BookDetail;
import com.example.demo.domain.models.Book;


@Mapper
public class BookUserMapper{

    public BookCollection toBookCollection(Book book) {
        return new BookCollection(
                book.getIsbn(),
                book.getTitle(),
                book.getSynopsis(),
                book.getPrice(),
                book.getDiscount(),
                book.getCover()
        );
    }

    public BookDetail toBookDetail(Book book){
        return new BookDetail(
                book.getIsbn(),
                book.getTitle(),
                book.getPrice(),
                book.getDiscount(),
                book.getSynopsis(),
                book.getCover(),
                book.getGenres(),
                book.getCategory()
        );
    }

    }

