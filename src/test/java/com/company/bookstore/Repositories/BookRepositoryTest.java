package com.company.bookstore.Repositories;
import java.time.LocalDate;

import com.company.bookstore.models.Author;
import com.company.bookstore.models.Book;
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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();
    }

    @Test
    public void shouldCreateNewBook() {
        //Act...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPublishDate(LocalDate.of(2020,8,8));
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());

        bookRepository.save(book);

        //Assert...
        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertEquals(book1.get(), book);
    }


    @Test
    public void shouldFindBookById() {
        //Act...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setPublishDate(LocalDate.of(2020,8,8));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());

        bookRepository.save(book);
        //Assert.....
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldFindAllBooks() {
        //Act...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setPublishDate(LocalDate.of(2020,8,8));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());

        bookRepository.save(book);

        //Assert.....
        List<Book> allBooksList = bookRepository.findAll();
        assertEquals(1, allBooksList.size());
    }


    @Test
    public void shouldUpdateBook() {
        //Act...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setPublishDate(LocalDate.of(2020,8,8));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());

        bookRepository.save(book);

        //Assert
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);

    }

    @Test
    public void shouldDeleteAuthor() {
        //Act...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setPublishDate(LocalDate.of(2020,8,8));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getAuthorId());
        book.setPublisherId(publisher.getPublisherId());

        bookRepository.save(book);

        bookRepository.deleteById(book.getBookId());

        //Assert...
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldFindBookByAuthorId() {
        //Act...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("NY");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("NY");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getAuthorId());
        book.setPublishDate(LocalDate.of(2020,8,8));
        book.setPublisherId(publisher.getPublisherId());

        bookRepository.save(book);

        //Assert.....
        List<Book> authorsBooks = bookRepository.findBookByAuthorId(book.getAuthorId());
        assertEquals(1, authorsBooks.size());
    }
}
