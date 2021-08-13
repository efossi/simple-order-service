package com.sos.model;

public enum ProductDb {
    Orange(25.0),
    Apple(60.0);
    
    private double price;

    ProductDb(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
}