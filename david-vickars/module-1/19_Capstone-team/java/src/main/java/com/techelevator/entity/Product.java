package com.techelevator.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public abstract class Product {

    public static final int QUANTIY_DEFAULT=5;

    private String code;

    private String name;

    private BigDecimal price;

    private int quantity = QUANTIY_DEFAULT;

    public Product(){

    }

    public Product(String code, String name, BigDecimal price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String code, String name, BigDecimal price) {
        this(code, name, price, QUANTIY_DEFAULT);
    }

    public abstract String getMessage();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Objects.equals(code, product.code) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, price, quantity);
    }

    @Override
    public String toString(){
        return code + " " + name + " In-stock" + quantity + " " +
                price.setScale(2, RoundingMode.HALF_EVEN);
    }
}
