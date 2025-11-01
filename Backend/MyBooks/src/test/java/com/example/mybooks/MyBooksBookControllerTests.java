package com.example.mybooks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

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
}
