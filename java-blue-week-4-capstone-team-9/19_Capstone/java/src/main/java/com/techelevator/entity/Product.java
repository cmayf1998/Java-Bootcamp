package com.techelevator.entity;

import java.math.BigDecimal;
import java.util.Objects;

abstract public class Product implements Snackable {

    private String slotLocation;
    private String productName;
    private BigDecimal productPrice;
    private int quantity;


    public Product() {
    }

    public Product(String slotLocation, String productName, BigDecimal productPrice, int quantity) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String getSlotLocation(){
        return slotLocation;
    }

    public void setSlotLocation(String slotLocation) {
        this.slotLocation = slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {return quantity;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean productIsSoldOut(int quantity){
        return quantity < 0;
    }

    @Override
    public String toString() {
        return slotLocation + " | "
                + productName + " $"
                + productPrice + " "
                 + quantity + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Objects.equals(slotLocation, product.slotLocation) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(slotLocation, productName, productPrice, quantity);
    }
}

