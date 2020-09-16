package com.techelevator;

import com.techelevator.entity.Customer;
import com.techelevator.entity.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Driver {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        Customer cust1;

        cust1 = new Customer();

        System.out.println("Please enter your name: ");
        cust1.setName( scanner.nextLine() );

        System.out.println("Please enter your email: ");
        cust1.setEmail( scanner.nextLine() );

        System.out.println("Customer is " + cust1.getName() + " " + cust1.getEmail());

        Customer cust2 = new Customer("Tarek", "tarek@my.com");

        Transaction trans1 = new Transaction(LocalDate.now(), new BigDecimal(100), "Demo for Moe");
        cust2.setLastTransaction(trans1);
    }

    public Map<String, List<Customer>> createMap(){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Deon", "deon@myco.com"));
        customerList.add(new Customer("Gabe", "gabe@myco.com"));
        customerList.add(new Customer("Elana", "elana@myco.com"));

        List<Customer> otherCustomerList = new ArrayList<>();
        otherCustomerList.add(new Customer("Tat", "tat@myco.com"));
        otherCustomerList.add(new Customer("JK", "jk@myco.com"));
        otherCustomerList.add(new Customer("Mal", "mal@myco.com"));

        Map< String, List<Customer> > customerMap = new HashMap<>();
        customerMap.put("blue", customerList);
        customerMap.put("green", otherCustomerList);
        return customerMap;
    }
}
