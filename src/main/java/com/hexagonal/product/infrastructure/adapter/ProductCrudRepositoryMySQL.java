package com.hexagonal.product.infrastructure.adapter;

import com.hexagonal.product.infrastructure.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepositoryMySQL extends CrudRepository<ProductEntity,Integer> {
}
