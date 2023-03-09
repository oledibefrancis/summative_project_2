package com.company.bookstore.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Size(max =15)
    private String isbn;
    int authorId;
    @Size(max =70)
    private String title;
    private int publisherId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String publishDate;


    @Column(precision = 5, scale = 2)
    BigDecimal price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() &&
                getAuthorId() == book.getAuthorId() &&
                getPublisherId() == book.getPublisherId() &&
                Objects.equals(getIsbn(), book.getIsbn()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getPrice(), book.getPrice()) &&
                Objects.equals(getPublishDate(), book.getPublishDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getIsbn(), getAuthorId(), getTitle(), getPublisherId(), getPrice(),getPublishDate());
    }
}
