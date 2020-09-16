package com.techelevator;


import com.techelevator.entity.Product;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SplittableRandom;

public class Customer {

    private BigDecimal wallet = new BigDecimal("0.00");
    private BigDecimal walletBefore = new BigDecimal("0.00");
    private final BigDecimal[] dollarAmounts = new BigDecimal[]{new BigDecimal("1.00"), new BigDecimal("2.00"), new BigDecimal("5.00"), new BigDecimal("10.00")};
    private final BigDecimal[] changeAmounts = new BigDecimal[]{new BigDecimal("0.25"), new BigDecimal("0.10"), new BigDecimal("0.05")};

    public Customer() {
        wallet = new BigDecimal("0.00");
        walletBefore = new BigDecimal("0.00");
    }

    public String finishTransaction(){
            int nickel = 0;
            int dime = 0;
            int quarter = 0;
            while (wallet.compareTo(new BigDecimal(0)) == 1) {
                if(wallet.doubleValue() % .25 == 0){
                    quarter++;
                    wallet = wallet.subtract(new BigDecimal(.25));
                }
                if(wallet.doubleValue() % .10 == 0){
                    dime++;
                    wallet = wallet.subtract(new BigDecimal(.10));
                }
                if(wallet.doubleValue() % .05 == 0){
                  nickel++;
                    wallet = wallet.subtract(new BigDecimal(.05));
                }
            } return "nickel: " + nickel + "dime: " + dime  + "quarter: " + quarter;

    }

    public Boolean feedMoney(BigDecimal moneyIn) {
        for (BigDecimal value : dollarAmounts) {
            if (moneyIn.equals(value)) {
                walletBefore = wallet;
                wallet = wallet.add(moneyIn);
                System.out.println("Old Balance: $"+walletBefore+" New Balance: $"+ wallet);
                return true;
            }
        }
        System.out.println("Money Feed Failed... Make sure you are entering a whole dollar amount!");
        return false;
    }

    public String purchaseItem(Map<String, Product> productMap, String slotLocation) {
            Product selected = productMap.get(slotLocation);
            int currentQuantity = selected.getQuantity();
            selected.setQuantity(currentQuantity - 1);
            walletBefore = wallet;
            wallet = wallet.subtract(selected.getProductPrice());

           return selected.getProductName() + " "+ selected.getProductPrice()+ " " + wallet;
        }

    public BigDecimal getWallet() {
        return wallet;
    }

    public String getWalletBefore(){
        return walletBefore.toString();
    }


}
