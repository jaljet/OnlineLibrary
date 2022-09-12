package com.bushuev.boot_onlinelibrary.service;

import com.bushuev.boot_onlinelibrary.dao.BookRepository;
import com.bushuev.boot_onlinelibrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBook(int id) {
        Book book = null;
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            book = bookOptional.get();
        }
        return book;
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findAllByAuthorName(String authorName) {
        List<Book> books = bookRepository.findAllByAuthorName(authorName);
        return books;
    }
}
