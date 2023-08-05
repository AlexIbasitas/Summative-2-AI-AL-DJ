package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository repo;

    @BeforeEach
    public void setUp() throws Exception {
        repo.deleteAll();
    }

    @Test
    public void shouldAddAuthor() {
        // Arrange
        Author author = new Author();

        author.setFirstName("George R.R.");
        author.setLastName("Martin");
        author.setStreet("Winterfell Street");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("123-456-7890");
        author.setEmail("GRRM@gmail.com");

        author = repo.save(author);

        // Act
        Optional<Author> auth = repo.findById(author.getAuthorId());

        // Assert
        assertEquals(auth.get(), author);
    }

    @Test
    public void shouldGetAllAuthors() {
        // Add first author
        Author author = new Author();
        author.setFirstName("George R.R.");
        author.setLastName("Martin");
        author.setStreet("Winterfell Street");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("123-456-7890");
        author.setEmail("GRRM@gmail.com");
        author = repo.save(author);

        // Add second author
        Author author2 = new Author();
        author2.setFirstName("J.R.R");
        author2.setLastName("Tolkien");
        author2.setStreet("Gondor Way");
        author2.setCity("Oakland");
        author2.setState("CA");
        author2.setPostalCode("01234");
        author2.setPhone("012-345-6789");
        author2.setEmail("jrrtolkien@gmail.com");
        author2 = repo.save(author2);

        List<Author> authorList = repo.findAll();

        // Assert
        assertEquals(authorList.size(), 2);
    }

    @Test
    public void shouldReturnAnAuthorById() {
        // Arrange
        Author author = new Author();
        author.setFirstName("George R.R.");
        author.setLastName("Martin");
        author.setStreet("Winterfell Street");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("123-456-7890");
        author.setEmail("GRRM@gmail.com");
        author = repo.save(author);

        // Act - Find the author
        Optional<Author> auth = repo.findById(author.getAuthorId());

        // Assert they are equal
        assertEquals(auth.get(), author);
    }

    @Test
    public void shouldUpdateAuthorRecord() {
        // Arrange - Set up Author Record
        Author author = new Author();
        author.setFirstName("George R.R.");
        author.setLastName("Martin");
        author.setStreet("Winterfell Street");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("123-456-7890");
        author.setEmail("GRRM@gmail.com");
        author = repo.save(author);

        // Act - Update
        author.setFirstName("J.K.");
        author.setLastName("Rowling");
        repo.save(author);

        // Assert - comparison
        Optional<Author> auth = repo.findById(author.getAuthorId());

        assertEquals(auth.get(), author);
    }

    @Test
    public void shouldDeleteAuthorFromRecord() {
        // Arrange - set up the Author record
        Author author = new Author();
        author.setFirstName("George R.R.");
        author.setLastName("Martin");
        author.setStreet("Winterfell Street");
        author.setCity("San Jose");
        author.setState("CA");
        author.setPostalCode("12345");
        author.setPhone("123-456-7890");
        author.setEmail("GRRM@gmail.com");
        author = repo.save(author);

        // Act
        Optional<Author> auth = repo.findById(author.getAuthorId());

        // Assert
        assertEquals(auth.get(), author); // check if item is found

        repo.deleteById(author.getAuthorId()); // delete

        auth = repo.findById(author.getAuthorId()); //  auth to author again

        assertFalse(auth.isPresent()); // If the correct obj is deleted, isPresent must return false
    }

}