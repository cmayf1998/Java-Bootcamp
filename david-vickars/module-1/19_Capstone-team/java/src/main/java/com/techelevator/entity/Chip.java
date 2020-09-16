package com.techelevator.entity;

import java.math.BigDecimal;

public class Chip extends Product {

    public Chip(){

    }

    public Chip(String code, String name, BigDecimal price, int quantity) {
        super(code, name, price, quantity);
    }

    public Chip(String code, String name, BigDecimal price) {
        super(code, name, price);
    }

    @Override
    public String getMessage() {
        return "Crunch Crunch, Yum!";
    }


    public static void main(String[] args){
        Product testChip = new Chip("A1", "Test Chip", BigDecimal.ZERO);
        System.out.println("testChip quantity: " + testChip.getQuantity());
    }
}
