package com.example.mybooks.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
    @GetMapping("/books")
    List<Book> all(){
        return;
    }
}
