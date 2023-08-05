package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookRepository repo;


    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        repo.save(book);
    }

    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable int id) {
        Optional<Book> book = repo.findById(id);

        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

    @GetMapping("/books/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthorId(@PathVariable int id) {
        return repo.findBooksByAuthorId(id);
    }

}
