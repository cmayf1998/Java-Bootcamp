package com.techelevator;

import com.techelevator.entity.Customer;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Customer cust1 = new Customer();

        System.out.println("Please enter your name: ");
        cust1.setName( scanner.nextLine());

        System.out.println("Customer is" + cust1.getName() + " " + cust1.getEmail());
    }
}
