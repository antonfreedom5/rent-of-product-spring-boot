package com.yadchenko.demo.service.impl;

import com.yadchenko.demo.model.Product;
import com.yadchenko.demo.repository.ProductRepository;
import com.yadchenko.demo.repository.StorageRepository;
import com.yadchenko.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final StorageRepository storageRepository;

    @Override
    public Product add(Product product) {
        Product currentProduct = productRepository.findById(product.getId()).orElseGet(Product::new);
        currentProduct.setName(product.getName());
        currentProduct.setCount(product.getCount());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setStorage(storageRepository.getById(product.getStorage().getId()));
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
        Product currentProduct = productRepository.getById(product.getId());
        if (currentProduct.getCount() > 0) {
            currentProduct.setCount(currentProduct.getCount() - 1);
            return Optional.of(currentProduct);
        }
        return Optional.empty();
    }
}
