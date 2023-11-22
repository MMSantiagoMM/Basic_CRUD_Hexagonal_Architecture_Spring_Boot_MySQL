package com.hexagonal.product.application.mapper;

import com.hexagonal.product.application.dto.ProductDTO;
import com.hexagonal.product.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapperDTO {

    ProductMapperDTO INSTANCE = Mappers.getMapper(ProductMapperDTO.class);


    Product productDtoToProduct(ProductDTO productDTO);


}
