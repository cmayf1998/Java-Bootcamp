package com.techelevator;

import com.techelevator.entity.Product;

import java.math.BigDecimal;

    public class Gum extends Product {


        public Gum(String slotLocation, String productName, BigDecimal productPrice, int quantity) {
            super(slotLocation, productName, productPrice, quantity);
        }

        public String getMessage() {
            return "Chew Chew, Yum!";
        }
    }