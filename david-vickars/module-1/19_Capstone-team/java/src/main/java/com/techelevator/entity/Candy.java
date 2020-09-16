package com.techelevator.entity;

import java.math.BigDecimal;

public class Candy extends Product {

    public Candy(){

    }

    public Candy(String code, String name, BigDecimal price, int quantity) {
        super(code, name, price, quantity);
    }

    public Candy(String code, String name, BigDecimal price) {
        super(code, name, price);
    }

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }
}
