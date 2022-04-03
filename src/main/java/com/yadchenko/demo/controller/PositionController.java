package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Position;
import com.yadchenko.demo.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping()
    public Position add(@RequestBody String name) {
        return positionService.add(name);
    }

    @GetMapping()
    public List<Position> getAll() {
        return positionService.getAll();
    }

    @DeleteMapping()
    public void delete(@RequestBody Long id) {
        positionService.delete(id);
    }
}
