package com.sos.repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.sos.model.ProductDb;
import com.sos.model.product.Product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
@Service
public class ProductRepository {
    Map<String, Product> products = new ConcurrentHashMap<>();
    
    public ProductRepository() {
        
        Product orange = new Product()
                .setId(UUID.randomUUID().toString())
                .setCode(ProductDb.Orange.toString())
                .setPrice(ProductDb.Orange.getPrice())
                .setInventory(1000);
        
        Product apple = new Product()
                .setId(UUID.randomUUID().toString())
                .setCode(ProductDb.Apple.toString())
                .setPrice(ProductDb.Apple.getPrice())
                .setInventory(1000);

        products.put(orange.getId(),orange);
        products.put(apple.getId(),apple);
    }

}