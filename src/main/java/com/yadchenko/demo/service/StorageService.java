package com.yadchenko.demo.service;

import com.yadchenko.demo.model.Storage;

import java.util.List;

public interface StorageService {
    Storage add(Storage storage);

    List<Storage> getAll();

    void delete(Long id);
}
