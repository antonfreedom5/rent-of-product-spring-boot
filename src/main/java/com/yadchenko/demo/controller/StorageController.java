package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Storage;
import com.yadchenko.demo.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class StorageController {
    private final StorageService storageService;

    @PostMapping()
    public Storage add(@RequestBody Storage storage) {
        return storageService.add(storage);
    }

    @GetMapping()
    public List<Storage> getAll() {
        return storageService.getAll();
    }

    @DeleteMapping()
    public void delete(@RequestBody Long id) {
        storageService.delete(id);
    }
}
