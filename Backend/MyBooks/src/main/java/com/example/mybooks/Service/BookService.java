package com.example.mybooks.Service;

import com.example.mybooks.Interface.BookRepository;
import com.example.mybooks.Model.Book;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(UUID id){
        return bookRepository.findById(id);
    }
}
