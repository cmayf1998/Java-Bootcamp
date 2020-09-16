package com.techelevator.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class TellerMachine {

    private String manufacturer;

    private BigDecimal deposits;

    private BigDecimal withdrawals;

    public TellerMachine(String manufacturer, BigDecimal deposits, BigDecimal withdrawals) {
        this.manufacturer = manufacturer;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
    }

    public boolean isValidCardNumber(String cardNumber){
        if ( (cardNumber.length() == 16) && ("5".equals(cardNumber.substring(0, 1))) ){
            return true;
        }
        if ( ((cardNumber.length() == 14) || (cardNumber.length() == 16))
                && ("4".equals(cardNumber.substring(0, 1))) ){
            return true;
        }
        if ("3".equals(cardNumber.substring(0, 1))){
            if ( ("4".equals(cardNumber.substring(1, 2)))
                    || ("7".equals(cardNumber.substring(1, 2))) ) {
                return true;
            }
        }
        return false;
    }

    public BigDecimal getBalance(){
        return deposits.subtract(withdrawals);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TellerMachine)) return false;
        TellerMachine that = (TellerMachine) o;
        return Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(deposits, that.deposits) &&
                Objects.equals(withdrawals, that.withdrawals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, deposits, withdrawals);
    }

    @Override
    public String toString(){
        return "ATM - " + manufacturer + " - " + getBalance();
    }
}
