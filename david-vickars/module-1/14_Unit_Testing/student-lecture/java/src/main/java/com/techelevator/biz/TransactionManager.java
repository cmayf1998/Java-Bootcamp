package com.techelevator.biz;

import com.techelevator.entity.Customer;

import java.util.List;

public class TransactionManager {

    private List<Customer> customers;

    public TransactionManager() {}

    public TransactionManager(List<Customer> customers){
        this.customers = customers;
    }
}
