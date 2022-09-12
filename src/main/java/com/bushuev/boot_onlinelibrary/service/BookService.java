package com.bushuev.boot_onlinelibrary.service;

import com.bushuev.boot_onlinelibrary.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public void saveBook(Book book);

    public Book getBook(int id);

    public void deleteBook(int id);

    public List<Book> findAllByAuthorName(String authorName);


}
