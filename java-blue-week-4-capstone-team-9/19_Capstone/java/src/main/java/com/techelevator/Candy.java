package com.techelevator;

import com.techelevator.entity.Product;

import java.math.BigDecimal;

public class Candy extends Product {


    public Candy(String slotLocation, String productName, BigDecimal productPrice, int quantity) {
        super(slotLocation, productName, productPrice, quantity);
    }

    public String getMessage(){
        return "Munch Munch, Yum!";
    }


}
