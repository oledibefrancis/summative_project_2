package com.company.bookstore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publisherId;

    @Size(max = 50)
    private String name;

    @Size(max = 50)
    private String street;

    @Size(max = 50)
    private String city;

    @Size(max = 2, min = 2)
    private String state;

    @Size(max = 25)
    private String postalCode;
    @Size(max = 15)
    private String phone;

    @Size(max = 60)
    private String email;

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Publisher publisher = (Publisher) o;
        return getPublisherId() == publisher.getPublisherId() &&
                Objects.equals(getName(), publisher.getName()) &&
                Objects.equals(getStreet(), publisher.getStreet()) &&
                Objects.equals(getCity(), publisher.getCity()) &&
                Objects.equals(getState(), publisher.getState()) &&
                Objects.equals(getPostalCode(), publisher.getPostalCode()) &&
                Objects.equals(getPhone(), publisher.getPhone()) &&
                Objects.equals(getEmail(), publisher.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getPublisherId(),
                getName(),
                getStreet(),
                getCity(),
                getState(),
                getPostalCode(),
                getPhone(),
                getEmail());
    }
}
