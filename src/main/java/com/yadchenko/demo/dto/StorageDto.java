package com.yadchenko.demo.dto;

import com.yadchenko.demo.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class StorageDto {
    private String name;
    private String phone;
    private String address;
    private List<Product> products;
}
