package com.example.mybooks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.mybooks.Interface.BookRepository;
import com.example.mybooks.Model.Book;
import com.example.mybooks.Service.BookService;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MyBooksBookServiceUnitTests {
    
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private UUID mockId;
    private Book existingBook;
    private Book newBook;

    @BeforeEach
    void setup() {
        mockId = UUID.randomUUID();

        existingBook = new Book("Old Title", "Old Author", 2000, "12345");
        newBook = new Book("New Title", "New Author", 2025, "67890");
    }

    @Test
    void shouldUpdateExistingBook() {    
        when(bookRepository.findById(mockId)).thenReturn(Optional.of(existingBook));
        when(bookRepository.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Book result = bookService.updateBook(newBook, mockId);

        assertEquals("New Title", result.getTitle());
        assertEquals("New Author", result.getAuthor());
        assertEquals(2025, result.getPublishingYear());
        assertEquals("67890", result.getIsbn());
        verify(bookRepository).save(existingBook);
    }

    @Test
    void shouldCreateNewBookWhenNotFound() {
        when(bookRepository.findById(mockId)).thenReturn(Optional.empty());
        when(bookRepository.save(newBook)).thenReturn(newBook);

        Book result = bookService.updateBook(newBook, mockId);

        assertEquals(newBook, result);
        verify(bookRepository).save(newBook);
    }
}