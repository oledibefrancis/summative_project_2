package com.company.bookstore.controllers;
import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.PublisherRepository;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherRepository authorRepository;

    private ObjectMapper mapper = new ObjectMapper();

    public Publisher createPublisher() {
        Publisher publisher = new Publisher();
        publisher.setPublisherId(1);
        publisher.setName("Good Pubs");
        publisher.setPostalCode("77777");
        publisher.setPhone("111222777");
        publisher.setCity("Norfolk");
        publisher.setState("Va");
        publisher.setEmail("jdoe@email.com");
        publisher.setStreet("900 Coco Ave");
        return publisher;
    }


    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }


    @Test
    public void testGetAllPublishers() throws Exception {
        mockMvc.perform(get("/publishers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetPublisherById() throws Exception {
        Publisher author = createPublisher();

        when(authorRepository.findById(author.getPublisherId())).thenReturn(Optional.of(author));

        mockMvc.perform(get("/publishers/" + author.getPublisherId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testAddPublisher() throws Exception {
        Publisher author = createPublisher();

        when(authorRepository.findById(author.getPublisherId())).thenReturn(Optional.of(author));

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        post("/publishers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdatePublisher() throws Exception {
        Publisher author = createPublisher();

        when(authorRepository.findById(author.getPublisherId())).thenReturn(Optional.of(author));

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        put("/publishers/" + author.getPublisherId())
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeletePublisher() throws Exception {
        Publisher author = createPublisher();

        when(authorRepository.findById(author.getPublisherId())).thenReturn(Optional.of(author));

        authorRepository.deleteById(author.getPublisherId());

        mockMvc.perform(delete("/publishers/" + author.getPublisherId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}