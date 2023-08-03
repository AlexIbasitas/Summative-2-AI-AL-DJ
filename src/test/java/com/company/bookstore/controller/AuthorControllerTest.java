package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.repository.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    //Author author = new Author();

    @MockBean
    AuthorRepository repo;

    @BeforeEach
    public void setUp(){
        repo.deleteAll();
    }
    @Test
    public void shouldAddAnAuthorOnPostRequest() throws Exception {
        Author author = new Author();
        author.setAuthorId(1);
        author.setFirstName("Terry");
        author.setLastName("Pratchett");
        author.setStreet("Discworld Ave");
        author.setCity("Oakland");
        author.setState("CA");
        author.setPostalCode("94501");
        author.setPhone("555-444-3333");
        author.setEmail("TP@DiscoworldEmporium.net");

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(post("/authors")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnAllAuthorsOnGetRequest() throws Exception {
        Author author = new Author();
        author.setAuthorId(1);
        author.setFirstName("Terry");
        author.setLastName("Pratchett");
        author.setStreet("Discworld Ave");
        author.setCity("Oakland");
        author.setState("CA");
        author.setPostalCode("94501");
        author.setPhone("555-444-3333");
        author.setEmail("TP@DiscoworldEmporium.net");

        repo.save(author);
        mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnAnAuthorById() throws Exception{
        Author author = new Author();
        author.setAuthorId(1);
        author.setFirstName("Terry");
        author.setLastName("Pratchett");
        author.setStreet("Discworld Ave");
        author.setCity("Oakland");
        author.setState("CA");
        author.setPostalCode("94501");
        author.setPhone("555-444-3333");
        author.setEmail("TP@DiscoworldEmporium.net");

        repo.save(author);
        mockMvc.perform(get("/authors/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateAnAuthorRecord() throws Exception{
        // Arrange - Create and set up author for update
        Author author = new Author();
        author.setAuthorId(1);
        author.setFirstName("Terry");
        author.setLastName("Pratchett");
        author.setStreet("Discworld Ave");
        author.setCity("Oakland");
        author.setState("CA");
        author.setPostalCode("94501");
        author.setPhone("555-444-3333");
        author.setEmail("TP@DiscoworldEmporium.net");
        author.setAuthorId(1);

        repo.save(author); // save to repo

        author.setCity("Ankh-Morpork"); // Change the author
        String inputJson = mapper.writeValueAsString(author);


        // Act - request to update the author
        mockMvc.perform(put("/authors")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeleteAnAuthorById() throws Exception{
        // Create and save an author for deletion in next step
        Author author = new Author();
        author.setAuthorId(1);
        author.setFirstName("Terry");
        author.setLastName("Pratchett");
        author.setStreet("Discworld Ave");
        author.setCity("Oakland");
        author.setState("CA");
        author.setPostalCode("94501");
        author.setPhone("555-444-3333");
        author.setEmail("TP@DiscoworldEmporium.net");
        repo.save(author);

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(delete("/authors/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}