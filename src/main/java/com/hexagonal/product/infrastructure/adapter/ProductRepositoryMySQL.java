package com.hexagonal.product.infrastructure.adapter;

import com.hexagonal.product.domain.model.Product;
import com.hexagonal.product.domain.port.ProductRepository;
import com.hexagonal.product.infrastructure.entity.ProductEntity;
import com.hexagonal.product.infrastructure.exceptions.ProductNotFoundException;
import com.hexagonal.product.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public class ProductRepositoryMySQL implements ProductRepository {

    private final ProductCrudRepositoryMySQL productCrudRepositoryMySQL;
    private final ProductMapper productMapper;

    public ProductRepositoryMySQL(ProductCrudRepositoryMySQL productCrudRepositoryMySQL, ProductMapper productMapper) {
        this.productCrudRepositoryMySQL = productCrudRepositoryMySQL;
        this.productMapper = productMapper;
    }


    @Override
    public Iterable<Product> getProducts() {
        return productMapper.toProducts(productCrudRepositoryMySQL.findAll());
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
        productCrudRepositoryMySQL.save(ProductMapper.INSTANCE.toEntity(product));
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
