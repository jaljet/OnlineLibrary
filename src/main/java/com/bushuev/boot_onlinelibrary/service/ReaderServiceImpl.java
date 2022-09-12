package com.bushuev.boot_onlinelibrary.service;

import com.bushuev.boot_onlinelibrary.dao.ReaderRepository;
import com.bushuev.boot_onlinelibrary.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public void saveReader(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public Reader getReader(int id) {
        Reader reader = null;
        Optional<Reader> readerOptional = readerRepository.findById(id);
        if(readerOptional.isPresent()){
            reader = readerOptional.get();
        }
        return reader;
    }

    @Override
    public void deleteReader(int id) {
        readerRepository.deleteById(id);
    }

    @Override
    public List<Reader> findAllReaderByName(String name) {
        List<Reader> readers = readerRepository.findAllByName(name);
        return readers;
    }
}
