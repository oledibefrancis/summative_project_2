package com.company.bookstore.Repositories;

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
        authorRepository.deleteAll();
        bookRepository.deleteAll();
        publisherRepository.deleteAll();
    }


    public Author createAuthor(){
        //Arrange...
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

    public Book createBook(){
        Author author = createAuthor();
        Publisher publisher = createPublisher();

        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getPublisherId());
        return book;
    }


    @Test
    public void shouldCreateNewBook() {

        //Arrange...
        Author author = createAuthor();

        Publisher publisher = createPublisher();

        authorRepository.save(author);
        publisherRepository.save(publisher);


        //Act...
        Book book = createBook();

        book = bookRepository.save(book);

        //Assert...
        Optional<Book> book1 = bookRepository.findById(book.getBookId());

        assertEquals(book1.get(), book);
    }


    @Test
    public void shouldFindBookById() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("New York");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("New York");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        //Act....
        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getPublisherId());

        //Assert.....
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldFindAllBooks() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("New York");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("New York");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        //Act....
        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getPublisherId());

        //Arrange...
        Author author2 = new Author();
        author2.setFirstName("Francis");
        author2.setLastName("Oledibe");
        author2.setStreet("900, Bello way");
        author2.setCity("Lagos");
        author2.setState("New York");
        author2.setPostalCode("72202");
        author2.setPhone("111-222-3456");
        author2.setEmail("francis@gmail.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Francis Oledibe");
        publisher2.setStreet("900, Bello way");
        publisher2.setCity("Lagos");
        publisher2.setState("New York");
        publisher2.setPostalCode("72202");
        publisher2.setPhone("111-222-3456");
        publisher2.setEmail("francis@gmail.com");

        authorRepository.save(author2);
        publisherRepository.save(publisher2);

        //Act....
        Book book2 = new Book();
        book2.setIsbn("12345");
        book2.setPrice(new BigDecimal("300.00"));
        book2.setTitle("Things Fall Apart");
        book2.setAuthorId(author.getId());
        book2.setPublisherId(publisher.getPublisherId());

        //Act....
        bookRepository.save(book);
        bookRepository.save(book2);

        //Assert.....
        List<Book> allBooksList = bookRepository.findAll();
        assertEquals(2, allBooksList.size());
    }


    @Test
    public void shouldUpdateBook() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("New York");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("New York");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);


        //Act....
        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getPublisherId());
        bookRepository.save(book);

        book.setIsbn("98023");
        book.setPrice(new BigDecimal("400.00"));
        bookRepository.save(book);

        //Assert
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertEquals(book1.get(), book);

    }

    @Test
    public void shouldDeleteAuthor() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("New York");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("New York");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);


        //Act....
        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getPublisherId());
        bookRepository.save(book);

        bookRepository.deleteById(book.getBookId());

        //Assert...
        Optional<Book> book1 = bookRepository.findById(book.getBookId());
        assertFalse(book1.isPresent());
    }

    @Test
    public void shouldFindBookByAuthorId() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("Francis");
        author.setLastName("Oledibe");
        author.setStreet("900, Bello way");
        author.setCity("Lagos");
        author.setState("New York");
        author.setPostalCode("72202");
        author.setPhone("111-222-3456");
        author.setEmail("francis@gmail.com");

        Publisher publisher = new Publisher();
        publisher.setName("Francis Oledibe");
        publisher.setStreet("900, Bello way");
        publisher.setCity("Lagos");
        publisher.setState("New York");
        publisher.setPostalCode("72202");
        publisher.setPhone("111-222-3456");
        publisher.setEmail("francis@gmail.com");

        authorRepository.save(author);
        publisherRepository.save(publisher);

        //Act....
        Book book = new Book();
        book.setIsbn("12345");
        book.setPrice(new BigDecimal("300.00"));
        book.setTitle("Things Fall Apart");
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getPublisherId());

        //Assert.....
        List<Book> authorsBooks = bookRepository.findBookByAuthorId(book.getAuthorId());
        assertEquals(1, authorsBooks.size());
    }
}
