package com.yadchenko.demo.service;

import com.yadchenko.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee add(Employee employee);

    List<Employee> getAll();

    void delete(Long id);
}
