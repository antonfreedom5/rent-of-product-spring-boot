package com.yadchenko.demo.service.impl;

import com.yadchenko.demo.model.Employee;
import com.yadchenko.demo.repository.EmployeeRepository;
import com.yadchenko.demo.repository.PositionRepository;
import com.yadchenko.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;

    @Override
    public Employee add(Employee employee) {
        Employee currentEmployee = employeeRepository.findById(employee.getId()).orElseGet(Employee::new);
        currentEmployee.setName(employee.getName());
        currentEmployee.setAddress(employee.getAddress());
        currentEmployee.setPhone(employee.getPhone());
        currentEmployee.setPosition(positionRepository.getById(employee.getPosition().getId()));
        return currentEmployee;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
