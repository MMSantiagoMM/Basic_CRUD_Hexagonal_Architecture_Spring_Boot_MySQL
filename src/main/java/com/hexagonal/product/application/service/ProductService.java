package com.hexagonal.product.application.service;

import com.hexagonal.product.application.dto.ProductDTO;
import com.hexagonal.product.domain.model.Product;

import java.util.Iterator;
import java.util.List;

public interface ProductService {

    Iterable<Product> getProducts();
    Product getProductById (Integer id);
    Product saveProduct (ProductDTO product);
    Boolean deleteProduct(Integer id);
}
