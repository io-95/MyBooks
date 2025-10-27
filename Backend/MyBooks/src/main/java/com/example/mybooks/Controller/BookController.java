package com.example.mybooks.Controller;
import com.example.mybooks.Model.Book;
import com.example.mybooks.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
    private final BookService service;

    BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    List<Book> all(){
        return service.findAll();
    }

    @GetMapping("/books/{id}")
    Book findById(@PathVariable String id){
        return null;
    }

    @PostMapping("/books/")
    Book createNewBook(@RequestBody Book newBook){
        return null;
    }

    @PutMapping("/books/{id}")
    Book updateBook(@PathVariable String id, @RequestBody Book newBook){
        return null;
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable String id){
        return;
    }
}
