package com.company.bookstore.Repositories;

import com.company.bookstore.models.Author;
import com.company.bookstore.repositories.AuthorRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    public Author createAuthor() {
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");
        return author;
    }

    @Test
    public void shouldCreateNewPublisher() {
        //Arrange...
        Author author = createAuthor();

        authorRepository.save(author);

        //Act....
        author = authorRepository.save(author);

        //Assert.....
        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);
    }


    @Test
    public void shouldFindAuthorById() {
        //Arrange...
        Author author = createAuthor();

        //Act....
        author = authorRepository.save(author);

        //Assert.....
        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldFindAllPublishers() {
        //Arrange.....
        Author author = createAuthor();

        Author author2 = createAuthor();

        //Act....
        authorRepository.save(author);
        authorRepository.save(author2);

        //Assert.....
        List<Author> authorList = authorRepository.findAll();
        assertEquals(2, authorList.size());
    }


    @Test
    public void shouldUpdateAuthor() {

        //Arrange.....
        Author author = createAuthor();

        //Act....
        authorRepository.save(author);

        author.setEmail("oledibe@gmail.com");
        author.setPhone("444,476,9083");

        authorRepository.save(author);

        //Assert
        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertEquals(author1.get(), author);

    }

    @Test
    public void shouldDeleteAuthor() {
        //Arrange.....
        Author author = createAuthor();

        authorRepository.save(author);

        //Act....
        authorRepository.deleteById(author.getAuthorId());

        //Assert...
        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());
        assertFalse(author1.isPresent());
    }

}

