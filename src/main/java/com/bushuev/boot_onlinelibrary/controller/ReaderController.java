package com.bushuev.boot_onlinelibrary.controller;

import com.bushuev.boot_onlinelibrary.entity.Book;
import com.bushuev.boot_onlinelibrary.entity.Reader;
import com.bushuev.boot_onlinelibrary.service.BookService;
import com.bushuev.boot_onlinelibrary.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ReaderController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    @GetMapping("/readers")
    private List<Reader> showAllReaders() {
        List<Reader> allReaders = readerService.getAllReaders();
        return allReaders;
    }

    @PostMapping("/readers")
    public Reader addNewReader(@RequestBody Reader reader) {
        readerService.saveReader(reader);

        return reader;
    }

    @PutMapping("/readers")
    public Reader updateReader(@RequestBody Reader reader) {
        readerService.saveReader(reader);

        return reader;
    }

    @PutMapping("/readers/addBookToReader/{readerId}")
    public Reader addBookToReader(@PathVariable int readerId, @RequestBody Book book) {
        Reader reader = readerService.getReader(readerId);
        reader.addBookToReader(book);

        book.setReader(reader);
        bookService.saveBook(book);
        readerService.saveReader(reader);

        return reader;
    }

    @DeleteMapping("/readers/{id}")
    public String deleteReader(@PathVariable int id) {
        List<Book> books = readerService.getReader(id).getBooks();
        for (Book book : books) {
            book.setReader(null);
            bookService.saveBook(book);
        }

        readerService.deleteReader(id);
        return "Reader with ID = " + id + " has been deleted";
    }
}
