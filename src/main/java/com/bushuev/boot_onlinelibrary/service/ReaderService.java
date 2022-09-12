package com.bushuev.boot_onlinelibrary.service;

import com.bushuev.boot_onlinelibrary.entity.Book;
import com.bushuev.boot_onlinelibrary.entity.Reader;

import java.util.List;

public interface ReaderService {

    public List<Reader> getAllReaders();

    public void saveReader(Reader reader);

    public Reader getReader(int id);

    public void deleteReader(int id);

    public List<Reader> findAllReaderByName(String name);


}
