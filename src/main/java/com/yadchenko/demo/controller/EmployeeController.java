package com.yadchenko.demo.controller;

import com.yadchenko.demo.model.Employee;
import com.yadchenko.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping()
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @GetMapping()
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
