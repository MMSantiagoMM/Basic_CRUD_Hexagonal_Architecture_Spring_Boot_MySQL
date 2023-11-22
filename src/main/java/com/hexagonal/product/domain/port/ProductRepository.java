package com.hexagonal.product.domain.port;

import com.hexagonal.product.domain.model.Product;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Iterable<Product> getProducts();
    Optional<Product> getProduct(Integer id);
    Product saveProduct(Product product);
    Boolean deleteProductById(Integer id);
}
