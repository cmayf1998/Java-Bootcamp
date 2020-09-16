package com.techelevator.shoppingcart;

public class ShoppingCart {
    private double totalAmountOwed;
    private int totalNumberOfItems;

    public ShoppingCart(){
        totalAmountOwed = 0.0;
        totalNumberOfItems = 0;
    }
//setters and getters:
    public double getTotalAmountOwed() {
        return totalAmountOwed;
    }
    public int getTotalNumberOfItems() {
        return totalNumberOfItems;
    }

    //methods:
    public double getAveragePricePerItem() {
        if (totalNumberOfItems > 0) {
            return totalAmountOwed / totalNumberOfItems;
        } else {
            return 0;
        }
    }


    public void addItems(int numberOfItems, double pricePerItem) {
        totalNumberOfItems = numberOfItems;
        totalAmountOwed += (pricePerItem * numberOfItems);
    }

    public void empty() {
        totalNumberOfItems = 0;
        totalAmountOwed = 0.0;

    }
}
