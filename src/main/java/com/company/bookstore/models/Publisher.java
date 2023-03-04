package com.company.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Publisher {

//    name varchar(50)not null,
//    street varchar(50) not null,
//    city varchar(50) not null,
//    state char(2) not null,
//    postal_code varchar(25) not null,
//    phone varchar(15) not null,
//    email varchar(60) not null
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publisherId;

    @Size()
    private String name;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
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
