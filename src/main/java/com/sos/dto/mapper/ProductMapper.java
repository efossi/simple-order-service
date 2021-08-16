package com.sos.dto.mapper;

import com.sos.dto.ProductDto;
import com.sos.model.product.Product;

public class ProductMapper {
    public static ProductDto toSimpleDto(Product product) {
    
        return new ProductDto()
                .setCode(product.getCode())
                .setName(product.getName());
    }
    
    public static Product fromDto(ProductDto product) {
        
        return new Product()
                .setCode(product.getCode())
                .setName(product.getName())
                .setPrice(product.getPrice());
    }
}