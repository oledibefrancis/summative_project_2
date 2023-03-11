package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.repositories.AuthorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorRepository authorRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public Author createAuthor() {
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");
        author.setCity("Norfolk");
        author.setState("Va");
        author.setEmail("jdoe@email.com");
        author.setStreet("900 Coco Ave");
        return author;
    }


    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }


    @Test
    public void testGetAllAuthors() throws Exception {
        mockMvc.perform(get("/authors"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAuthorById() throws Exception {
        Author author = createAuthor();

        when(authorRepository.findById(author.getAuthorId())).thenReturn(Optional.of(author));

        mockMvc.perform(get("/authors/" + author.getAuthorId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddAuthor() throws Exception {
        Author author = createAuthor();

        when(authorRepository.findById(author.getAuthorId())).thenReturn(Optional.of(author));

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        post("/authors")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        Author author = createAuthor();

        when(authorRepository.findById(author.getAuthorId())).thenReturn(Optional.of(author));

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        put("/authors/" + author.getAuthorId())
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        Author author = createAuthor();

        when(authorRepository.findById(author.getAuthorId())).thenReturn(Optional.of(author));

        authorRepository.deleteById(author.getAuthorId());

        mockMvc.perform(delete("/authors/" + author.getAuthorId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

}