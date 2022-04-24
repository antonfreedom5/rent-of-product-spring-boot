package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Storage;
import com.yadchenko.demo.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @PostMapping()
    public Storage add(@RequestBody Storage storage) {
        return storageService.add(storage);
    }

    @PostMapping("/has-products")
    public Boolean hasProducts(@RequestBody Long id) {
        return storageService.hasProducts(id);
    }

    @GetMapping()
    public List<Storage> getAll() {
        return storageService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        storageService.delete(id);
    }
}
