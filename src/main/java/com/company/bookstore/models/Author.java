package com.company.bookstore.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "author")
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "authorId")
    private Set<Book> albums = new HashSet<>();

    @Size(max = 50)
    String firstName;
    @Size(max = 50)
    String lastName;
    @Size(max = 50)
    String street;
    @Size(max = 50)
    String city;
    @Size(min = 2, max = 2)
    String state;
    @Size(max = 25)
    String postalCode;
    @Size(max = 15)
    String phone;
    @Size(max = 60)
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Book> albums) {
        this.albums = albums;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getId() == author.getId() &&
                Objects.equals(getAlbums(), author.getAlbums()) &&
                Objects.equals(getFirstName(), author.getFirstName()) &&
                Objects.equals(getLastName(), author.getLastName()) &&
                Objects.equals(getStreet(), author.getStreet()) &&
                Objects.equals(getCity(), author.getCity()) &&
                Objects.equals(getState(), author.getState()) &&
                Objects.equals(getPostalCode(), author.getPostalCode()) &&
                Objects.equals(getPhone(), author.getPhone()) &&
                Objects.equals(getEmail(), author.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getAlbums(),
                getFirstName(),
                getLastName(),
                getStreet(),
                getCity(),
                getState(),
                getPostalCode(),
                getPhone(),
                getEmail());
    }
}
