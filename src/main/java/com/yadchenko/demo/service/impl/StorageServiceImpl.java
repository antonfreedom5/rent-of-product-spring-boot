package com.yadchenko.demo.service.impl;


import com.yadchenko.demo.model.Product;
import com.yadchenko.demo.model.Storage;
import com.yadchenko.demo.repository.ProductRepository;
import com.yadchenko.demo.repository.StorageRepository;
import com.yadchenko.demo.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;
    private final ProductRepository productRepository;

    @Override
    public Storage add(Storage storage) {
        Storage currentStorage =  storageRepository.findById(storage.getId()).orElseGet(Storage::new);
        currentStorage.setAddress(storage.getAddress());
        currentStorage.setName(storage.getName());
        currentStorage.setPhone(storage.getPhone());
        storageRepository.save(currentStorage);
        return currentStorage;
    }

    @Override
    public List<Storage> getAll() {
        return storageRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        storageRepository.deleteById(id);
    }

    @Override
    public Boolean hasProducts(Long id) {
        Storage storage = storageRepository.findById(id).orElseThrow();
        return productRepository.findAllByStorage(storage).size() > 0;
    }
}
