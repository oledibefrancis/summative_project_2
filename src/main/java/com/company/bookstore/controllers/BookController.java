package com.company.bookstore.controllers;

import com.company.bookstore.models.Book;
import com.company.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository repo;

    public Book getBook(int bookId){
        Optional<Book> result = repo.findById(bookId);

        if (!result.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");

        return result.get();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repo.findAll();
    }


    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return getBook(bookId);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book item) {
        return repo.save(item);
    }

    @PutMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book updateBook(@RequestBody Book item, @PathVariable int bookId) {
        Book instance = getBook(bookId);

        if (item.getIsbn() != null) instance.setIsbn(item.getIsbn());
        instance.setAuthorId(item.getAuthorId());
        if (item.getTitle() != null) instance.setTitle(item.getTitle());
        instance.setPublisherId(item.getPublisherId());
        if (item.getPrice() != null) instance.setPrice(item.getPrice());


        return repo.save(instance);
    }

    @DeleteMapping("/books/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book deleteBook(@PathVariable int bookId) {
        Book instance = getBook(bookId);

        repo.delete(instance);

        return instance;
    }
}
