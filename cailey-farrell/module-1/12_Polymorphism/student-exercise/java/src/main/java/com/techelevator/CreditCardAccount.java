package com.techelevator;

public class CreditCardAccount implements Accountable {

    private String accountNumber;

    private String accountHolder;

    private int debt;

    private int balance;

    //Constructor
    public CreditCardAccount(String accountHolder, String accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }

    //Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getDebt() {
        return debt;
    }

    public int getBalance() {
        return (0-debt);
    }

    //Methods
    public int pay(int amountToPay) {
       debt = debt - amountToPay;
       return debt;
    }

    public int charge(int amountToCharge) {
       debt = amountToCharge + debt;
       return amountToCharge;
    }


}
