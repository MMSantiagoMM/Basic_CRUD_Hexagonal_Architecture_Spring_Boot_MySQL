package com.hexagonal.product.infrastructure.rest.controller;


import com.hexagonal.product.application.service.DomainProductService;
import com.hexagonal.product.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final DomainProductService service;


    public ProductController(DomainProductService service) {
        this.service = service;
    }


    @PostMapping
    ResponseEntity<Product> create (@RequestBody Product product){
        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(service.getProducts(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getOne(@PathVariable Integer id){
        return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete (@PathVariable Integer id){
        if(service.deleteProduct(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
