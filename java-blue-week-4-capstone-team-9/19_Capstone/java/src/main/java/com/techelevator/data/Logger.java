package com.techelevator.data;

import com.techelevator.Customer;
import com.techelevator.entity.Product;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    static PrintWriter logWriter;
    static DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss");
    static LocalDateTime timeOfTransaction = LocalDateTime.now();

    public static void open() {
        try {
            logWriter = new PrintWriter(new FileWriter("transactions.log", true));
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public static void writeMessage(Product product, Customer customer) {
        logWriter.println(dateAndTime.format(timeOfTransaction) + " "
                + product.getProductName() + " "
                + product.getSlotLocation() + " $"
                + customer.getWalletBefore () + " $" +
                customer.getWallet());
    }

    public static void writeMessage(Customer customer, BigDecimal quantity){
        logWriter.println(dateAndTime.format(timeOfTransaction) + " " + "FEED MONEY" +" $"+quantity+customer.getWallet());
    }

    public static void writeMessage(Customer customer){
        logWriter.println(dateAndTime.format(timeOfTransaction) + " " + "GIVE CHANGE" + customer.getWallet() + "$0.00");
    }

    public static void close() {
        logWriter.close();
    }

}


// 01/01/2016 12:00:00 PM FEED MONEY: $5.00 $5.00
//>01/01/2016 12:00:15 PM FEED MONEY: $5.00 $10.00
//>01/01/2016 12:00:20 PM Crunchie B4 $10.00 $8.50
//>01/01/2016 12:01:25 PM Cowtales B2 $8.50 $7.50
//>01/01/2016 12:01:35 PM GIVE CHANGE: $7.50 $0.00
//>```


