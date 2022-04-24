package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Product;
import com.yadchenko.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
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

    @PostMapping("/has-clients")
    public Boolean hasClients(@RequestBody Long id) {
        return productService.hasClients(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
