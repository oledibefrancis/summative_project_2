package com.company.bookstore.controllers;

import com.company.bookstore.models.Author;
import com.company.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository repo;

    public Author getAuthor(int authorId){
        Optional<Author> result = repo.findById(authorId);

        if (!result.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found");

        return result.get();
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return repo.findAll();
    }


    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        return getAuthor(authorId);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author item) {
        return repo.save(item);
    }

    @PutMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Author updateAuthor(@RequestBody Author item, @PathVariable int authorId) {
        Author instance = getAuthor(authorId);

        if (item.getStreet() != null) instance.setStreet(item.getStreet());
        if (item.getFirstName() != null) instance.setFirstName(item.getFirstName());
        if (item.getLastName() != null) instance.setLastName(item.getLastName());
        if (item.getEmail() != null) instance.setEmail(item.getEmail());
        if (item.getPhone() != null) instance.setPhone(item.getPhone());
        if (item.getEmail() != null) instance.setEmail(item.getEmail());
        if (item.getState() != null) instance.setState(item.getState());
        if (item.getPostalCode() != null) instance.setPostalCode(item.getPostalCode());


        return repo.save(instance);
    }

    @DeleteMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Author deleteAuthor(@PathVariable int authorId) {
        Author instance = getAuthor(authorId);

        repo.delete(instance);

        return instance;
    }
}
