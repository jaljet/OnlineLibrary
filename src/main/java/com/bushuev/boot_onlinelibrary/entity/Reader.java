package com.bushuev.boot_onlinelibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "readers")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "surname")
    private String surname;
    @JsonManagedReference
    @OneToMany(mappedBy = "reader", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @Column(name = "books_id_taken")
    private List<Book> books;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Role")
    private String role;

    public Reader() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addBookToReader(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
        book.setReader(this);
    }

    public void deleteBookFromReader(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.remove(book);
        book.setReader(null);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
