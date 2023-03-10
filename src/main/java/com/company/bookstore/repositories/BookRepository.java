package com.company.bookstore.repositories;

import com.company.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findBookByAuthorId(int id);
}
