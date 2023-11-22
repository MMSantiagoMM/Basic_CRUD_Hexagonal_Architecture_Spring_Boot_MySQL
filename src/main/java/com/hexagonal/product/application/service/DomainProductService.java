package com.hexagonal.product.application.service;

import com.hexagonal.product.application.dto.ProductDTO;
import com.hexagonal.product.application.mapper.ProductMapperDTO;
import com.hexagonal.product.domain.model.Product;
import com.hexagonal.product.domain.port.ProductRepository;
import com.hexagonal.product.infrastructure.adapter.ProductRepositoryMySQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainProductService implements ProductService{


    private final ProductRepositoryMySQL productRepositoryMySQL;

    public DomainProductService(ProductRepositoryMySQL productRepositoryMySQL) {
        this.productRepositoryMySQL = productRepositoryMySQL;
    }


    @Override
    public Iterable<Product> getProducts() {
        return productRepositoryMySQL.getProducts();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepositoryMySQL.getProduct(id).get();
    }

    @Override
    public Product saveProduct(ProductDTO product) {
        return productRepositoryMySQL.saveProduct(
                ProductMapperDTO.INSTANCE.productDtoToProduct(product)
        );
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        return productRepositoryMySQL.deleteProductById(id);
    }
}
