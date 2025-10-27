package com.example.mybooks.Controller;
import com.example.mybooks.Model.Book;
import com.example.mybooks.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


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
    ResponseEntity<Book> findById(@PathVariable String id){
        return service.findById(UUID.fromString(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    Book createNewBook(@RequestBody Book newBook){
        return service.save(newBook);
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
