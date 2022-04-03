package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Product;
import com.yadchenko.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping()
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping()
    public List<Product> getAll() {
        return productService.getAll();
    }

    @DeleteMapping()
    public void delete(@RequestBody Long id) {
        productService.delete(id);
    }
}
