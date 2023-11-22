package com.hexagonal.product.infrastructure.mapper;


import com.hexagonal.product.domain.model.Product;
import com.hexagonal.product.infrastructure.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);



    Product toProduct(ProductEntity productEntity);


    ProductEntity toEntity(Product product);


    Iterable<Product> toProducts(Iterable<ProductEntity> productEntityIterable);
}
