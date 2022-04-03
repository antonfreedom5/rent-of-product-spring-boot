package com.yadchenko.demo.dto;

import com.yadchenko.demo.model.Position;
import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String phone;
    private String address;
    private Position position;
}
