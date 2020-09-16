package com.techelevator.client;

import com.techelevator.biz.TransactionManager;
import com.techelevator.entity.Customer;

import java.util.Scanner;

public class ConsoleInteraction {

    private Scanner scanner;

    private TransactionManager manager;

    public ConsoleInteraction(Scanner scanner, TransactionManager manager) {
        this.scanner = scanner;
    }

    public String getInput(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public Customer addCustomer() {
       Customer customer = new Customer();
       customer.setName( getInput("Please enter your name: "));
       return customer;
    }

    public void displayMenu() {
        while (true){
            // prompt your main menu until the user says quit
        }
    }
}
