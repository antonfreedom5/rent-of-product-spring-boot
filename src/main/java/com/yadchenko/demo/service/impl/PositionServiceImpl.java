package com.yadchenko.demo.service.impl;

import com.yadchenko.demo.model.Position;
import com.yadchenko.demo.repository.PositionRepository;
import com.yadchenko.demo.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public Position add(String name) {
        Position currentPosition = positionRepository.findPositionByName(name).orElseGet(Position::new);
        currentPosition.setName(name);
        return currentPosition;
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
