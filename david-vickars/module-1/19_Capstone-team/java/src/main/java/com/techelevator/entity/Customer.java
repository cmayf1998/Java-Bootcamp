package com.techelevator.entity;

import java.math.BigDecimal;

public class Customer {

    private String name;

    private BigDecimal balance;

    public Customer(){

    }
    public Customer(String name, BigDecimal balance){
        this.name = name;
        this.balance = balance;
    }
    public Customer(BigDecimal balance){
        this(null, balance);
    }
}
