package com.techelevator;

import com.techelevator.entity.Product;

import java.math.BigDecimal;

public class Chip extends Product {


    public Chip(String slotLocation, String productName, BigDecimal productPrice, int quantity) {
       super(slotLocation, productName, productPrice, quantity);
    }

    public String getMessage(){
        return "Crunch Crunch, Yum!";
    }


}
