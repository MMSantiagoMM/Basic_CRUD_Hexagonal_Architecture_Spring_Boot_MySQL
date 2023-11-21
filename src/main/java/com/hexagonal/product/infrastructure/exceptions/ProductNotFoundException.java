package com.hexagonal.product.infrastructure.exceptions;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer id){
        super("This product was not found");
    }
}
