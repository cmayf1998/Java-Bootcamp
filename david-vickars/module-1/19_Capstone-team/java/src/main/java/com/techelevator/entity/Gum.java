package com.techelevator.entity;

import java.math.BigDecimal;

public class Gum extends Product {

    public Gum(){

    }

    public Gum(String code, String name, BigDecimal price, int quantity) {
        super(code, name, price, quantity);
    }

    public Gum(String code, String name, BigDecimal price) {
        super(code, name, price);
    }

    @Override
    public String getMessage() {
        return "Chew Chew, Yum!";
    }
}
