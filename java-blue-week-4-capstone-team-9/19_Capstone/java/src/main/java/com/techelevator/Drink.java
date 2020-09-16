package com.techelevator;

import com.techelevator.entity.Product;

import java.math.BigDecimal;

public class Drink extends Product {


    public Drink(String slotLocation, String productName, BigDecimal productPrice, int quantity) {
        super(slotLocation, productName, productPrice, quantity);
    }

    public String getMessage(){
        return "Glug Glug, Yum!";
    }


}
