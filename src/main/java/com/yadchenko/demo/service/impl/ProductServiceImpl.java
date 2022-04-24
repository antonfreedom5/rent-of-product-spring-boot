package com.yadchenko.demo.service.impl;

import com.yadchenko.demo.model.Product;
import com.yadchenko.demo.repository.ClientRepository;
import com.yadchenko.demo.repository.ProductRepository;
import com.yadchenko.demo.repository.StorageRepository;
import com.yadchenko.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StorageRepository storageRepository;

    private final ClientRepository clientRepository;

    @Override
    public Product add(Product product) {
        Product currentProduct = productRepository.findById(product.getId()).orElseGet(Product::new);
        currentProduct.setName(product.getName());
        currentProduct.setCount(product.getCount());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setStorage(storageRepository.findById(product.getStorage().getId()).get());
        productRepository.save(currentProduct);
        return currentProduct;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> recountProduct(Product product) {
        Product currentProduct = productRepository.findById(product.getId()).get();
        if (currentProduct.getCount() > 0) {
            currentProduct.setCount(currentProduct.getCount() - 1);
            return Optional.of(currentProduct);
        }
        return Optional.empty();
    }

    @Override
    public Boolean hasClients(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        return clientRepository.findAll().stream().anyMatch(item -> item.getProducts().contains(product));
    }
}
