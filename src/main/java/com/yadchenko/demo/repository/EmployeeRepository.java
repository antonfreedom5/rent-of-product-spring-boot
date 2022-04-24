package com.yadchenko.demo.repository;

import com.yadchenko.demo.model.Employee;
import com.yadchenko.demo.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByPosition(Position position);
}
