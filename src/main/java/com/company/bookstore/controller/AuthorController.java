package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository repo;

    // CREATE
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthorRecord(@RequestBody Author author) {
        return repo.save(author);
    }


    // READ ALL
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return repo.findAll();
    }

    // READ By ID
    @GetMapping("/authors/{id}")
    public Optional<Author> getAuthorById(@PathVariable int id) {
        return repo.findById(id);
    }


    // UPDATE AUTHORS
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthorRecord(@RequestBody Author author) {
        repo.save(author);
    }

    // DELETE AUTHORS
    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable int id) {
        repo.deleteById(id);
    }
}
