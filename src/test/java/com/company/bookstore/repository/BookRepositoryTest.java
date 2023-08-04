package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        Author author = new Author();
        author.setFirstName("Thea");
        author.setLastName("DeLaCruz");
        author.setStreet("123 Sesame St");
        author.setCity("Torrance");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("310-949-6901");
        author.setEmail("TheaDeLaCruz@gmail.com");
        Set<Book> bookList = new HashSet<>();
        author.setBooks(bookList);

        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Eagle Hill");
        publisher.setStreet("Waverly Place");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("54321");
        publisher.setPhone("981-400-4321");
        publisher.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setPublishDate(LocalDate.of(2023, 8, 4));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Lightning Thief");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);

        Optional<Book> testBook = bookRepo.findById(book.getId());

        assertEquals(testBook.get(),book);
    }

    @Test
    public void testGetBookById() {
        Author author = new Author();
        author.setFirstName("Thea");
        author.setLastName("DeLaCruz");
        author.setStreet("123 Sesame St");
        author.setCity("Torrance");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("310-949-6901");
        author.setEmail("TheaDeLaCruz@gmail.com");
        Set<Book> bookList = new HashSet<>();
        author.setBooks(bookList);

        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Eagle Hill");
        publisher.setStreet("Waverly Place");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("54321");
        publisher.setPhone("981-400-4321");
        publisher.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setPublishDate(LocalDate.of(2023, 8, 4));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Lightning Thief");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);
        Optional<Book> testBook = bookRepo.findById(book.getId());

        assertEquals(testBook.get(), book);
    }
    @Test
    public void testGetAllBooks() {
        Author author = new Author();
        author.setFirstName("Thea");
        author.setLastName("DeLaCruz");
        author.setStreet("123 Sesame St");
        author.setCity("Torrance");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("310-949-6901");
        author.setEmail("TheaDeLaCruz@gmail.com");
        Set<Book> bookList = new HashSet<>();
        author.setBooks(bookList);


        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Eagle Hill");
        publisher.setStreet("Waverly Place");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("54321");
        publisher.setPhone("981-400-4321");
        publisher.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setPublishDate(LocalDate.of(2023, 8, 4));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Lightning Thief");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        book = bookRepo.save(book);
        Optional<Book> testBook = bookRepo.findById(book.getId());

        Author author2 = new Author();
        author2.setFirstName("Alex");
        author2.setLastName("Ibasitas");
        author2.setStreet("456 Sesame St");
        author2.setCity("Irvine");
        author2.setState("CA");
        author2.setPostalCode("12395");
        author2.setPhone("310-940-6901");
        author2.setEmail("Alex@gmail.com");
        Set<Book> bookList2 = new HashSet<>();
        author.setBooks(bookList2);

        authorRepo.save(author2);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Eagle Hill");
        publisher2.setStreet("Waverly Place");
        publisher2.setCity("New York City");
        publisher2.setState("NY");
        publisher2.setPostal_code("54321");
        publisher2.setPhone("981-400-4321");
        publisher2.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher2);

        Book book2 = new Book();
        book2.setIsbn("9783169484109");
        book2.setPublishDate(LocalDate.of(2023, 7, 4));
        book2.setAuthorId(author.getAuthorId());
        book2.setTitle("The Lightning Thief Final Destination");
        book2.setPublisherId(publisher.getId());
        book2.setPrice(new BigDecimal("39.99"));

        book2 = bookRepo.save(book2);
        Optional<Book> testBook2 = bookRepo.findById(book2.getId());

        List<Book> testBookList = bookRepo.findAll();
        assertEquals(2, testBookList.size());
    }
    @Test
    public void testUpdateBook() {
        Author author = new Author();
        author.setFirstName("Thea");
        author.setLastName("DeLaCruz");
        author.setStreet("123 Sesame St");
        author.setCity("Torrance");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("310-949-6901");
        author.setEmail("TheaDeLaCruz@gmail.com");
        Set<Book> bookList = new HashSet<>();
        author.setBooks(bookList);

        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Eagle Hill");
        publisher.setStreet("Waverly Place");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("54321");
        publisher.setPhone("981-400-4321");
        publisher.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setPublishDate(LocalDate.of(2023, 8, 4));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Lightning Thief");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        bookRepo.save(book);

        book.setTitle("A better Title");

        bookRepo.save(book);
        Optional<Book> testBook = bookRepo.findById(book.getId());
        assertEquals(testBook.get(), book);
    }
    @Test
    public void testDeleteBook() {
        Author author = new Author();
        author.setFirstName("Thea");
        author.setLastName("DeLaCruz");
        author.setStreet("123 Sesame St");
        author.setCity("Torrance");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("310-949-6901");
        author.setEmail("TheaDeLaCruz@gmail.com");
        Set<Book> bookList = new HashSet<>();
        author.setBooks(bookList);

        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Eagle Hill");
        publisher.setStreet("Waverly Place");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("54321");
        publisher.setPhone("981-400-4321");
        publisher.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setPublishDate(LocalDate.of(2023, 8, 4));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Lightning Thief");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        bookRepo.save(book);
        bookRepo.deleteById(book.getId());

        Optional<Book> testBook = bookRepo.findById(book.getId());
        assertFalse(testBook.isPresent());
    }
    @Test
    public void testGetBooksByAuthorId() {
        Author author = new Author();
        author.setFirstName("Thea");
        author.setLastName("DeLaCruz");
        author.setStreet("123 Sesame St");
        author.setCity("Torrance");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("310-949-6901");
        author.setEmail("TheaDeLaCruz@gmail.com");
        Set<Book> bookList = new HashSet<>();
        author.setBooks(bookList);

        authorRepo.save(author);

        Publisher publisher = new Publisher();
        publisher.setName("Eagle Hill");
        publisher.setStreet("Waverly Place");
        publisher.setCity("New York City");
        publisher.setState("NY");
        publisher.setPostal_code("54321");
        publisher.setPhone("981-400-4321");
        publisher.setEmail("EagleHill@gmail.com");

        publisherRepo.save(publisher);

        Book book = new Book();
        book.setIsbn("9783169484100");
        book.setPublishDate(LocalDate.of(2023, 8, 4));
        book.setAuthorId(author.getAuthorId());
        book.setTitle("The Lightning Thief");
        book.setPublisherId(publisher.getId());
        book.setPrice(new BigDecimal("19.99"));

        bookRepo.save(book);

        List<Book> testBookList = bookRepo.findBooksByAuthorId(book.getAuthorId());

        assertEquals(testBookList.get(0), book);
    }



}
