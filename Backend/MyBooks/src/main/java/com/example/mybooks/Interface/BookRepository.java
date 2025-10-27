package com.example.mybooks.Interface;

import com.example.mybooks.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface class BookRepository extends JpaRepository<Book, UUID> {
}
