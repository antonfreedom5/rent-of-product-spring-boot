package com.yadchenko.demo.service.impl;

import com.yadchenko.demo.model.Position;
import com.yadchenko.demo.repository.EmployeeRepository;
import com.yadchenko.demo.repository.PositionRepository;
import com.yadchenko.demo.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public Position add(Position position) {
        Position currentPosition = positionRepository.findById(position.getId()).orElseGet(Position::new);
        currentPosition.setName(position.getName());
        positionRepository.save(currentPosition);
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

    @Override
    public Boolean hasEmployees(Long id) {
        Position position = positionRepository.findById(id).orElseThrow();
        return employeeRepository.findAllByPosition(position).size() > 0;
    }
}
