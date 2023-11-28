package com.hexagonal.product.application.service;

import com.hexagonal.product.application.dto.ProductDTO;
import com.hexagonal.product.application.mapper.ProductMapperDTO;
import com.hexagonal.product.domain.model.Product;
import com.hexagonal.product.infrastructure.adapter.ProductRepositoryMySQL;
import org.springframework.stereotype.Service;

@Service
public class DomainProductService implements ProductService{


    private final ProductRepositoryMySQL productRepositoryMySQL;
    private final ProductMapperDTO productMapperDTO;

    public DomainProductService(ProductRepositoryMySQL productRepositoryMySQL, ProductMapperDTO productMapperDTO) {
        this.productRepositoryMySQL = productRepositoryMySQL;
        this.productMapperDTO = productMapperDTO;
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
                productMapperDTO.productDtoToProduct(product)
        );
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        return productRepositoryMySQL.deleteProductById(id);
    }
}
