package com.techelevator;

import com.techelevator.entity.Product;

import java.math.BigDecimal;
import java.util.Map;

public class VendingManager {

    private Map<String, Product> productMap;

    private Customer customer;


    public VendingManager(Map<String, Product> productMap, Customer customer) {
        this.customer = customer;
        this.productMap = productMap;
    }

    public String getVendingMachineItems() {
        String displayItems = "";
        for (Product value : productMap.values()) {
            displayItems = displayItems + "\n" + value;

        }
        return displayItems;
    }

    public Product getProduct(String slotLocation){
        Product currentProduct = productMap.get(slotLocation);
       return currentProduct;
    }

    public boolean feedMoney(BigDecimal amount) {
        return customer.feedMoney(amount);

    }

    public String purchaseItem(String slotLocation) {
        return customer.purchaseItem(productMap, slotLocation);
    }

    public BigDecimal getWallet() {
        return customer.getWallet();
    }

    public boolean isSoldOut(String slotLocation) {
        Product currentProduct = productMap.get(slotLocation);
        return currentProduct.productIsSoldOut(currentProduct.getQuantity());

    }

    public boolean productExists(String slotLocation) {
        return productMap.containsKey(slotLocation);

    }

    public BigDecimal getPrice(String slotLocation){
        Product currentProduct = productMap.get(slotLocation);
        return currentProduct.getProductPrice();
    }

    public String finishTransaction(){
        return customer.finishTransaction();
    }


}



