package com.techelevator.biz;

import com.techelevator.entity.Customer;
import com.techelevator.entity.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {

    private Map<Integer, List<Transaction>> transactions;

    public TransactionManager(Object o) {
    }

    public Map<Integer, List<Transaction>> getTransactions(){
        return transactions;
    }

    public TransactionManager(){
        this(new HashMap<>());

    }
    public TransactionManager(Map<Integer>, List<Transaction>> transactions) {
        if (transactions == null) {
            this.transactions = new HashMap<>();
        } else {
            this.transactions = transactions;
        }
    }
//passed in via reference, modify object
    public boolean add(Customer customer, Transaction transaction){
        transaction.setId(9);
        return true;
    }

    public boolean add(Customer customer, Transaction transaction){
        List<Transaction> list = new ArrayList<>();
        boolean result = list.add(transaction);
        if (!result){
            return false;
        }
        transactions.put(customer.getId(), list);
        return false;
    }
}
