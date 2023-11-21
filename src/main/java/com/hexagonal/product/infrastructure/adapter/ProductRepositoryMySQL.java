package com.hexagonal.product.infrastructure.adapter;

import com.hexagonal.product.domain.model.Product;
import com.hexagonal.product.domain.port.ProductRepository;
import com.hexagonal.product.infrastructure.entity.ProductEntity;
import com.hexagonal.product.infrastructure.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepositoryMySQL implements ProductRepository {

    private final ProductCrudRepositoryMySQL productCrudRepositoryMySQL;

    public ProductRepositoryMySQL(ProductCrudRepositoryMySQL productCrudRepositoryMySQL) {
        this.productCrudRepositoryMySQL = productCrudRepositoryMySQL;
    }


    @Override
    public List<Product> getProducts() {
        List<Product> products = Collections.singletonList((Product)
                productCrudRepositoryMySQL.findAll());
        return products;
    }

    @Override
    public Optional<Product> getProduct(Integer id) {
        ProductEntity product = productCrudRepositoryMySQL.findById(id)
                .orElseThrow(()-> new ProductNotFoundException(id));
        Product product2 = new Product();
        product2.setName(product.getName());
        product2.setDescription(product.getDescription());
        product2.setPrice(product.getPrice());
        return Optional.of(product2);
    }

    @Override
    public Product saveProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productCrudRepositoryMySQL.save(productEntity);
        return product;
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        if(productCrudRepositoryMySQL.existsById(id)){
            productCrudRepositoryMySQL.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
