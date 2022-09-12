package com.bushuev.boot_onlinelibrary.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bookname")
    private String bookName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "authorname")
    private String authorName;
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "yearofprinting")
    private int yearOfPrinting;

    @ManyToOne(cascade = {CascadeType.DETACH,
                            CascadeType.MERGE,
                                CascadeType.PERSIST,
                                    CascadeType.REFRESH})
    @JoinColumn(name = "readerid")
    @JsonBackReference
    private Reader reader;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearOfPrinting() {
        return yearOfPrinting;
    }

    public void setYearOfPrinting(int yearOfPrinting) {
        this.yearOfPrinting = yearOfPrinting;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book() {
    }
}
