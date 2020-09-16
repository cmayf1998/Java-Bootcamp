package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    public int withdraw(int amountToWithdraw) {

        if (super.getBalance() - amountToWithdraw <= -100) {
            amountToWithdraw = -10;
        }
        if (super.getBalance() < 0) {
           amountToWithdraw += 10;

        }
        return super.withdraw(amountToWithdraw);
    }
}
//if the hashcodes do not equal the equals method will be false;
//hash code collision (want to reduce this)
//if you have overwritten and need method from superclass use super.
//extends =  all fields and methods from its superclass
//Scope is different

