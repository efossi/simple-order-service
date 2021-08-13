package com.sos.model.order;

import com.sos.model.product.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDetail {
    private String id;

    Product product;

    int quantity;
    
}