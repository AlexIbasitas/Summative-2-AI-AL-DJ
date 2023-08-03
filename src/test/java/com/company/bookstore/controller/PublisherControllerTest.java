package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublisherController.class)
class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository publisherRepository;

    // ObjectMapper used to convert Java objects to JSON and vice versa
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldCreatePublisher() throws Exception {

        // ACT
        Publisher publisher = new Publisher();
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Bing");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        mockMvc.perform(post("/publishers")               // Perform the POST request
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(publisher))
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isCreated()); // ASSERT (status code is 201)

    }

    @Test
    public void shouldGetPublisherById() throws Exception {
        // ACT
        Publisher publisher = new Publisher();
        publisher.setId(1);
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Lin");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepository.save(publisher);

        mockMvc.perform(get("/publishers/1")               // Perform the GET request
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isOk()); // ASSERT (status code is 200)
    }

    @Test
    public void shouldGetAllPublishers() throws Exception {
        // ACT
        Publisher publisher = new Publisher();
        publisher.setId(1);
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Lin");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepository.save(publisher);

        Publisher publisher1 = new Publisher();
        publisher1.setId(2);
        publisher1.setCity("Brooklyn");
        publisher1.setEmail("stacy@netflix.com");
        publisher1.setName("Stacy Bob");
        publisher1.setPhone("123=456=7890");
        publisher1.setPostal_code("11111");
        publisher1.setState("NY");
        publisher1.setStreet("123 Sesame Lane");

        publisherRepository.save(publisher1);

        mockMvc.perform(get("/publishers")               // Perform the GET request
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isOk()); // ASSERT (status code is 200)
    }

    @Test
    public void shouldUpdatePublisher() throws Exception {
        // ACT
        Publisher publisher = new Publisher();
        publisher.setId(1);
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Mark");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepository.save(publisher);

        publisher.setCity("Long Island");

        mockMvc.perform(put("/publishers")               // Perform the PUT request
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(publisher))
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeletePublisher() throws Exception {

        Publisher publisher = new Publisher();
        publisher.setId(1);
        publisher.setCity("Brooklyn");
        publisher.setEmail("stacy@netflix.com");
        publisher.setName("Stacy Lina");
        publisher.setPhone("123=456=7890");
        publisher.setPostal_code("11111");
        publisher.setState("NY");
        publisher.setStreet("123 Sesame Lane");

        publisherRepository.save(publisher);

        mockMvc.perform(delete("/publishers/1")               // Perform the DELETE request
                )
                .andDo(print())                         // Print results to console
                .andExpect(status().isNoContent());

    }

}