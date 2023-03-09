package com.company.bookstore.Repositories;


import com.company.bookstore.models.Publisher;
import com.company.bookstore.repositories.AuthorRepository;
import com.company.bookstore.repositories.BookRepository;
import com.company.bookstore.repositories.PublisherRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        publisherRepository.deleteAll();
    }

    public Publisher createPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        return publisher;
    }

    @Test
    public void shouldCreateNewPublisher() {
        //Arrange...

        Publisher publisher = createPublisher();

        publisherRepository.save(publisher);

        //Act....
        publisher = publisherRepository.save(publisher);

        //Assert.....
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());

        assertEquals(publisher1.get(), publisher);
    }


    @Test
    public void shouldFindPublisherById() {
        //Arrange...
        Publisher publisher = createPublisher();
        //Act....
        publisher = publisherRepository.save(publisher);

        //Assert.....
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());

        assertEquals(publisher1.get(), publisher);
    }

    @Test
    public void shouldFindAllPublishers() {
        //Arrange.....
        Publisher publisher = createPublisher();

        Publisher publisher2 = createPublisher();


        //Act....
        publisherRepository.save(publisher);
        publisherRepository.save(publisher2);

        //Assert.....
        List<Publisher> expectedCustomer = publisherRepository.findAll();
        assertEquals(2, expectedCustomer.size());
    }


    @Test
    public void shouldUpdatePublisher() {

        //Arrange.....
        Publisher publisher = createPublisher();

        //Act....
        publisherRepository.save(publisher);

        publisher.setEmail("oledibe@gmail.com");
        publisher.setPhone("444,476,9083");

        publisherRepository.save(publisher);

        //Assert
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());
        assertEquals(publisher1.get(), publisher);

    }

    @Test
    public void shouldDeleteCustomer() {
        //Arrange.....
        Publisher publisher = createPublisher();

        publisherRepository.save(publisher);

        //Act....
        publisherRepository.deleteById(publisher.getPublisherId());

        //Assert...
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());

        assertFalse(publisher1.isPresent());
    }

}
