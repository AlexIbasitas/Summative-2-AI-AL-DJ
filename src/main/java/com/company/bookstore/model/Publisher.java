package com.company.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "publisher")
public class Publisher implements Serializable {

    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String street;

    private String city;

    private String state;

    private String postal_code;

    private String phone;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.EAGER)
    @JoinColumn(name="publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(int id, String name, String street, String city, String state, String postal_code, String phone, String email, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books.addAll(books);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return getId() == publisher.getId() && Objects.equals(getName(), publisher.getName()) && Objects.equals(getStreet(), publisher.getStreet()) && Objects.equals(getCity(), publisher.getCity()) && Objects.equals(getState(), publisher.getState()) && Objects.equals(getPostal_code(), publisher.getPostal_code()) && Objects.equals(getPhone(), publisher.getPhone()) && Objects.equals(getEmail(), publisher.getEmail()) && Objects.equals(getBooks(), publisher.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getCity(), getState(), getPostal_code(), getPhone(), getEmail(), getBooks());
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                '}';
    }
}
