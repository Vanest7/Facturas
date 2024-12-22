package com.example.demo.controller.admin;


import com.example.demo.controller.admin.webModel.BookCollection;
import com.example.demo.controller.admin.webModel.mapper.BookAdminMapper;
import com.example.demo.controller.common.PaginatedResponse;
import com.example.demo.domain.models.Book;
import com.example.demo.domain.useCase.admin.BookInsertUseCase;
import com.example.demo.domain.useCase.user.BookCountUseCase;
import com.example.demo.domain.useCase.user.BookDeleteByIdUseCase;
import com.example.demo.domain.useCase.user.BookGetAllUseCase;
import com.example.demo.domain.useCase.user.BookGetByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(BookAdminController.URL)
@RequiredArgsConstructor
public class BookAdminController {

    public static final String URL = "/api/admin/books";

    private final BookDeleteByIdUseCase bookDeleteByIdUseCase;
    private final BookCountUseCase bookCountUseCase;
    private final BookGetAllUseCase bookGetAllUseCase;
    private final BookGetByIdUseCase bookGetByIdUseCase;
    private final BookAdminMapper bookAdminMapper;
    private final BookInsertUseCase bookInsertUseCase;

    @Value("${app.base.url}")
    private String baseUrl;

     @Value("${app.pageSize.default}")
    private String defaultPageSize;

    @GetMapping
    public ResponseEntity<PaginatedResponse<BookCollection>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ){
        int pageSize = (size != null) ? size : Integer.parseInt(defaultPageSize);

        List<BookCollection> books = bookGetAllUseCase.execute(page -1, pageSize)
                .stream()
                .map(bookAdminMapper::toBookCollection)
                .toList();

        int total = bookCountUseCase.execute();

        PaginatedResponse<BookCollection> response = new PaginatedResponse<>(books, total, page, pageSize, baseUrl+URL);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getById(@PathVariable int id){
        Optional<Book> book = bookGetByIdUseCase.execute(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){

        bookInsertUseCase.execute(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {

         bookDeleteByIdUseCase.execute(id);

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
