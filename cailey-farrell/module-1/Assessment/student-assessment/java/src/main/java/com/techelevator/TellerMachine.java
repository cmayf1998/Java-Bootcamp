package com.techelevator;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.awt.image.PixelConverter;

import java.math.BigDecimal;
import java.util.Scanner;

public class TellerMachine {

    public String manufacturer = new String();
    private BigDecimal deposits = new BigDecimal(0.00);
    private BigDecimal withdrawals = new BigDecimal(0.00);
    public BigDecimal balance = new BigDecimal(0.00);
    public String cardNumber = new String("0");


    public TellerMachine(String manufacturer, BigDecimal deposits, BigDecimal withdrawals) {
        this.manufacturer = manufacturer;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
    }

    public boolean isValidCardNumber(String cardNumber){
        if ((cardNumber.length() == 16) && ("5".equals(cardNumber.substring(0,1)))) {
            return true;
        }
        if (((cardNumber.length() == 14) || (cardNumber.length() == 16))
            && ("4".equals(cardNumber.substring(0,1))){
            return true;
        }
    return false;
    }

    public BigDecimal getBalance(){
        return deposits.subtract(withdrawals);
    }

//no setter for getBalance becuase its a calculated field

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getDeposits() {
        return deposits;
    }

    public void setDeposits(BigDecimal deposits) {
        this.deposits = deposits;
    }

    public BigDecimal getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(BigDecimal withdrawals) {
        this.withdrawals = withdrawals;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    //methodology
    public boolean validCardnumber(String cardNumber){
        if (cardNumber.substring(0,1) == "5" && cardNumber.length() == 16){
            return true;
        } else if (cardNumber.substring(0,1) == "4" && (cardNumber.length() == 16 || cardNumber.length() == 13)) {
            return true;
        } else if (cardNumber.substring(0,1) == "3" && (cardNumber.substring(1,2) == "4" || cardNumber.substring(1,2) == "7"))

    }

    @Override
    public int hashCode() {
        return super.hashCode(manufacturer, deposits, withdrawals);
    }


    public String toString() {
        return "ATM - " + manufacturer + " - " + getBalance();
    }
}
