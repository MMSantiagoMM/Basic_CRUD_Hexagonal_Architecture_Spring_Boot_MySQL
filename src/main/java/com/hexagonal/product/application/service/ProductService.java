package com.hexagonal.product.application.service;

import com.hexagonal.product.domain.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();
    Product getProductById (Integer id);
    Product saveProduct (Product product);
    Boolean deleteProduct(Integer id);
}
