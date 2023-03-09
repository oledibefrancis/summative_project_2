package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.repositories.BookRepository;
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

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository bookRepository;


    private ObjectMapper mapper = new ObjectMapper();

    public Book createBook() {
        Book book = new Book();
        book.setBookId(1);
        book.setPublishDate("2020-08-05");
        book.setPrice(new BigDecimal("20.29"));
        book.setIsbn("235235235235");
        book.setAuthorId(1);
        book.setPublisherId(1);
        book.setTitle("Harry Porter");
        return book;
    }


    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
    }


    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = createBook();

        when(bookRepository.findById(book.getBookId())).thenReturn(Optional.of(book));

        mockMvc.perform(get("/books/" + book.getBookId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
//    public void testGetBookByAuthorId() throws Exception {
//        Book book = createBook();
//
//        when(bookRepository.findBooksByAuthorId(book.getBookId())).thenReturn(Optional.of(book));
//
//        mockMvc.perform(get("/books/author/" + book.getAuthorId()))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }

    @Test
    public void testAddBook() throws Exception {
        Book book = createBook();

        when(bookRepository.findById(book.getBookId())).thenReturn(Optional.of(book));

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(
                        post("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = createBook();

        when(bookRepository.findById(book.getBookId())).thenReturn(Optional.of(book));

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(
                        put("/books/" + book.getBookId())
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = createBook();

        when(bookRepository.findById(book.getBookId())).thenReturn(Optional.of(book));

        bookRepository.deleteById(book.getBookId());

        mockMvc.perform(delete("/books/" + book.getBookId()))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}