package com.bushuev.boot_onlinelibrary.controller;

import com.bushuev.boot_onlinelibrary.entity.Book;
import com.bushuev.boot_onlinelibrary.entity.Reader;
import com.bushuev.boot_onlinelibrary.service.BookService;
import com.bushuev.boot_onlinelibrary.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/libapi")
public class LibraryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;


    @GetMapping("/books")
    private List<Book> showAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        return allBooks;
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book) {
        bookService.saveBook(book);

        return book;
    }


    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        bookService.saveBook(book);

        return book;
    }


    @PutMapping("/readers/returnBook/{bookId}")
    public Reader returnBookToLibrary(@PathVariable int bookId) {
        Book book = bookService.getBook(bookId);
        Reader reader = book.getReader();

        reader.deleteBookFromReader(book);
        book.setReader(null);

        bookService.saveBook(book);
        readerService.saveReader(reader);

        return reader;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id) {
        Book book = bookService.getBook(id);

        bookService.deleteBook(id);
        return "Book with ID = " + id + " has been deleted";
    }


    @GetMapping("/books/byAuthor/{authorName}")
    public List<Book> showAllBooksByAuthorName(@PathVariable String authorName) {
        List<Book> books = bookService.findAllByAuthorName(authorName);

        return books;
    }

}
