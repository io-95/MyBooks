package com.example.mybooks.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;


@RestController
public class BookController {
    @GetMapping("/books")
    List<Book> all(){
        return null;
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
