package com.techelevator.product;

import javax.naming.Name;

public class Product {
    private String name;
    private Double price;
    private Double weightInOunces;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeightInOunces(double weightInOunces) {
        this.weightInOunces = weightInOunces;
    }

    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }

    public Double getWeightInOunces() {
        return weightInOunces;
    }

}

