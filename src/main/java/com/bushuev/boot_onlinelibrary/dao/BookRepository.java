package com.bushuev.boot_onlinelibrary.dao;

import com.bushuev.boot_onlinelibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findAllByAuthorName(String authorName);
}
