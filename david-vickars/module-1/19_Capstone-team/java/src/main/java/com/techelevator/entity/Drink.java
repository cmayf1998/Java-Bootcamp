package com.techelevator.entity;

import java.math.BigDecimal;

public class Drink extends Product {

    public Drink(){

    }

    public Drink(String code, String name, BigDecimal price, int quantity) {
        super(code, name, price, quantity);
    }

    public Drink(String code, String name, BigDecimal price) {
        super(code, name, price);
    }

    @Override
    public String getMessage() {
        return "Glug Glug, Yum!";
    }
}
