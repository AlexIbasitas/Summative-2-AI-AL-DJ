package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository repo;

    // Create
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return repo.save(publisher);
    }

    //Read (By Id)
    @GetMapping("/publishers/{id}")
    public Publisher getPublisherById(@PathVariable int id) {
        Optional<Publisher> returnValue = repo.findById(id);

        if (returnValue.isPresent()) {
            return returnValue.get();
        } else {
            return null;
        }
    }

    //Read (All)
    @GetMapping("/publishers")
    public List<Publisher> getPublishers() {
        return repo.findAll();
    }

    //Update
    //In Insomnia, the publisher_id you want to change needs to be sent in request body
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {
        repo.save(publisher);
    }

    //Delete
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }


}
