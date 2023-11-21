package com.hexagonal.product.infrastructure.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Double price;



}
