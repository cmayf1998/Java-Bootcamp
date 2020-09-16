package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer implements Accountable {

    private String name;

    private String address;

    private String phoneNumber;

    private List<Accountable> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] customerAccounts = new Accountable[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            customerAccounts[i] = (accounts.get(i));
        }
        return customerAccounts;
    }

    //Methods
    public int getBalance() {
        return getBalance();
    }


    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int sum = 0;
        for (int i = 0; i < accounts.size(); i++) {
            sum += accounts.get(i).getBalance();
        }
        if (sum >= 25000) {
            return true;
        }
        return false;
    }
}





