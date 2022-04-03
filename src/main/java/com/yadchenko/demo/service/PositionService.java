package com.yadchenko.demo.service;

import com.yadchenko.demo.model.Position;

import java.util.List;

public interface PositionService {
    Position add(String name);

    List<Position> getAll();

    void delete(Long id);
}
