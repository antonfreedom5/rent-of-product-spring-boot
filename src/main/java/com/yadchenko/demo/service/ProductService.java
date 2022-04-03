package com.yadchenko.demo.service;

import com.yadchenko.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product add(Product product);

    List<Product> getAll();

    void delete(Long id);

    public Optional<Product> recountProduct(Product product);
}
