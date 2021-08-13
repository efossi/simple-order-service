package com.sos.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Product {

    private String id;

    private String code;

    private int inventory;

    private String name;

    private double price;
    
}