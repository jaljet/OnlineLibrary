package com.bushuev.boot_onlinelibrary.dao;


import com.bushuev.boot_onlinelibrary.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReaderRepository extends JpaRepository<Reader, Integer> {
    public List<Reader> findAllByName(String name);
}
