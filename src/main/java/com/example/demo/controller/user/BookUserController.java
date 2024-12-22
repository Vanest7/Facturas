package com.example.demo.controller.user;


import com.example.demo.controller.common.PaginatedResponse;
import com.example.demo.controller.user.webModel.BookCollection;
import com.example.demo.controller.user.webModel.BookDetail;
import com.example.demo.controller.user.webModel.mapper.BookUserMapper;
import com.example.demo.domain.useCase.user.BookCountUseCase;
import com.example.demo.domain.useCase.user.BookGetAllUseCase;
import com.example.demo.domain.useCase.user.BookGetByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(BookUserController.URL)
@RequiredArgsConstructor
public class BookUserController {
    public static final String URL = "/api/user/books";

    @Value("${app.base.url}")
    private String baseUrl;

   @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final BookGetAllUseCase bookGetAllUseCase;
    private final BookGetByIdUseCase bookGetByIdUseCase;
    private final BookCountUseCase bookCountUseCase;
    private final BookUserMapper bookUserMapper;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ){
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);


        List<BookCollection> books = bookGetAllUseCase.execute(page -1, pageSize)
                .stream()
                .map(bookUserMapper::toBookCollection)
                .toList();

        int total = bookCountUseCase.execute();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl+URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookDetail>> getById(@PathVariable int id){
        Optional<BookDetail> book = bookGetByIdUseCase.execute(id).map(bookUserMapper::toBookDetail);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }





}
