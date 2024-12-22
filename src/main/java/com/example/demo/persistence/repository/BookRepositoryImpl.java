package com.example.demo.persistence.repository;

import com.example.demo.domain.models.Book;
import com.example.demo.domain.repository.BookRepository;
import com.example.demo.persistence.dao.BookDaoDb;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookDaoDb bookDaoDb;

    @Override
    public List<Book> getAll() {
        return bookDaoDb.getAll();
    }

    @Override
    public List<Book> getAll(int page, int size) {

        return bookDaoDb.getAll(page, size);
    }

    @Override
    public Optional<Book> findById(int id) {
        return bookDaoDb.findById(id);
    }

    @Override
    public void deleteBookById(int id) {
        bookDaoDb.deleteBookById(id);
    }

    @Override
    public int count() {

        return bookDaoDb.count();
    }

    @Override
    public int insert(Book book) {
        return bookDaoDb.insert(book);
    }
}
