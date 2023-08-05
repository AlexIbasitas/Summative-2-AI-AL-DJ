package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BookController.class)
@AutoConfigureMockMvc
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    private ObjectMapper mapper = new ObjectMapper();

    private List<Book> bookList;

    @BeforeEach
    public void setUp() {
    }


    @Test
    public void shouldCreateBookOnPost() throws Exception, com.fasterxml.jackson.core.JsonProcessingException {
        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setAuthorId(2);
        book.setTitle("The Lightning Thief");
        book.setPublisherId(3);
        book.setPrice(new BigDecimal("19.99"));

//        String bookAsJson = mapper.writeValueAsString(book);

        mockMvc.perform(post("/books")
                        .content(mapper.writeValueAsString(book))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldGetBookByIdOnGet() throws Exception {
        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setAuthorId(2);
        book.setTitle("The Lightning Thief");
        book.setPublisherId(3);
        book.setPrice(new BigDecimal("19.99"));

        String bookAsJson = mapper.writeValueAsString(book);

        mockMvc.perform(get("/books/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllBooksOnGet() throws Exception {
        mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateBookOnPut() throws Exception {
        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setAuthorId(2);
        book.setTitle("The Lightning Thief");
        book.setPublisherId(3);
        book.setPrice(new BigDecimal("19.99"));
        String bookAsJson = mapper.writeValueAsString(book);

        mockMvc.perform(put("/books")
                        .content(bookAsJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteBookOnDelete() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldGetBooksByAuthorIdOnGet() throws Exception {
        mockMvc.perform(get("/books/author/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
