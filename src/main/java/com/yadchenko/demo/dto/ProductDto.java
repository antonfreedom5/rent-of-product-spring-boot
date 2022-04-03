package com.yadchenko.demo.dto;

import com.yadchenko.demo.model.Storage;
import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private Long price;
    private Storage storage;
    private Long count;
}
