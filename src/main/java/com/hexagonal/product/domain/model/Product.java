package com.hexagonal.product.domain.model;


import lombok.Data;

@Data
public class Product {

    //private Integer id;
    private String name;
    private String description;
    private Double price;
}
