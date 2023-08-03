package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepo;

    @Autowired
    AuthorRepository authorRepo;

    @Autowired
    PublisherRepository publisherRepo;

    @BeforeEach
    public void setUp() throws Exception {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
        publisherRepo.deleteAll();
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setAuthorId(2);
        book.setTitle("The Lightning Thief");
        book.setPublisherId(3);
        book.setPrice(new BigDecimal("19.99"));
    }

    @Test
    public void testGetBookById() {
    }
    @Test
    public void testGetAllBooks() {
    }
    @Test
    public void testUpdateBook() {
    }
    @Test
    public void testDeleteBook() {
    }
    @Test
    public void testGetBooksByAuthorId() {
    }



}
