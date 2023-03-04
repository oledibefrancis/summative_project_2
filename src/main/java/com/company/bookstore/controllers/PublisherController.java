package com.company.bookstore.controllers;

import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    private PublisherRepository repo;

    public Publisher getPublisher(int publisherId){
        Optional<Publisher> result = repo.findById(publisherId);

        if (!result.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher not found");

        return result.get();
    }

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers() {
        return repo.findAll();
    }


    @GetMapping("/publishers/{publisherId}")
    public Publisher getPublisherById(@PathVariable int publisherId) {
        return getPublisher(publisherId);
    }

    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher item) {
        return repo.save(item);
    }

    @PutMapping("/publishers/{publisherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Publisher updatePublisher(@RequestBody Publisher item, @PathVariable int publisherId) {
        Publisher instance = getPublisher(publisherId);

        if (item.getStreet() != null) instance.setStreet(item.getStreet());
        if (item.getName() != null) instance.setName(item.getName());
        if (item.getEmail() != null) instance.setEmail(item.getEmail());
        if (item.getPhone() != null) instance.setPhone(item.getPhone());
        if (item.getCity() != null) instance.setCity(item.getCity());
        if (item.getState() != null) instance.setState(item.getState());
        if (item.getPostalCode() != null) instance.setPostalCode(item.getPostalCode());


        return repo.save(instance);
    }

    @DeleteMapping("/publishers/{publisherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Publisher deletePublisher(@PathVariable int publisherId) {
        Publisher instance = getPublisher(publisherId);

        repo.delete(instance);

        return instance;
    }
}
