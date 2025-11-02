package com.example.mybooks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.mybooks.Interface.BookRepository;
import com.example.mybooks.Model.Book;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MyBooksBookControllerTests {
    
    @Autowired
	private MockMvc mockMvc;

    @Test
    void shouldReturnBooksInDb() throws Exception{
        this.mockMvc.perform(get("/books")).andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.length()").value(5))
                        .andExpect(jsonPath("$[*].id").isNotEmpty())
                        .andExpect(jsonPath("$[*].title").isNotEmpty())
                        .andExpect(jsonPath("$[*].author").isNotEmpty());
    }

    @Autowired
    private BookRepository bookRepository;

    private UUID mockUuid;

    @BeforeEach
    @Tag("withDbEntry")
    void addMockBook(){
        Book mockBook = new Book("Test Title", "Author", 2024, "123456");
        mockBook = bookRepository.save(mockBook);
        this.mockUuid = mockBook.getId();
    }

    @Test
    @Tag("withDbEntry")
    void shouldReturnSingleBookById() throws Exception{
        
    }

    @Test
    @Tag("withDbEntry")
    void shouldDeleteBookInDb() throws Exception{
        this.mockMvc.perform(delete("/books/{mockUuid}", mockUuid))
                        .andExpect(status().isOk());

        boolean exists = bookRepository.existsById(mockUuid);
        assertFalse(exists, "Book should be deleted from the database");
    }
}
