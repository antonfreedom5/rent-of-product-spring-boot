package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Position;
import com.yadchenko.demo.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping()
    public Position add(@RequestBody Position position) {
        return positionService.add(position);
    }

    @PostMapping("/has-employees")
    public Boolean hasEmployees(@RequestBody Long id) {
        return positionService.hasEmployees(id);
    }

    @GetMapping()
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        positionService.delete(id);
    }
}
