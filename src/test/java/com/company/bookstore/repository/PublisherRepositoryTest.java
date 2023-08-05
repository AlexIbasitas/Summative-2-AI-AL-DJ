package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepo;

    @BeforeEach
    public void setUp() throws Exception {
        publisherRepo.deleteAll();
    }

    @Test
    public void addPublisher() {
        Publisher publisher = new Publisher();
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Drew");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void getPublisherById() {
        Publisher publisher = new Publisher();
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Matthews");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertTrue(publisher1.isPresent());
    }

    @Test
    public void getAllPublishers() {
        //Arrange...

        //Act...
        Publisher publisher = new Publisher();
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Flint");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepo.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setCity("Brooklyn");
        publisher2.setEmail("stacy@netflix.com");
        publisher2.setName("Stacy Jones");
        publisher2.setPhone("123=456=7890");
        publisher2.setPostal_code("11111");
        publisher2.setState("NY");
        publisher2.setStreet("123 Sesame Lane");

        publisherRepo.save(publisher2);

        List<Publisher> publisherList = publisherRepo.findAll();

        //Assert...
        assertEquals(2, publisherList.size());
    }

    @Test
    public void updatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Sosal");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepo.save(publisher);

        publisher.setCity("Manhattan");

        publisherRepo.save(publisher);

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

    }

    @Test
    public void deletePublisher() {

        Publisher publisher = new Publisher();
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Bing");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepo.save(publisher);

        publisherRepo.deleteById(publisher.getId());

        Optional<Publisher> publisher1 = publisherRepo.findById(publisher.getId());

        assertFalse(publisher1.isPresent());
    }

}