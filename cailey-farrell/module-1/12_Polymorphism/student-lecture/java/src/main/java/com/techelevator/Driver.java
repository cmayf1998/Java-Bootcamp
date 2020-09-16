package com.techelevator;

import com.techelevator.entity.Customer;
import com.techelevator.entity.Employee;
import com.techelevator.entity.Moveable;
import com.techelevator.entity.Person;
import javafx.scene.input.KeyCombination;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        Employee emp1 = new Employee("David", "david@myco.com", 123, "CEO", new BigDecimal( 100
        ));
        System.out.println(emp1);

        Bike bike1 = new Bike( 2);

        List<Moveable> moveList = new ArrayList<>();
        moveList.add(emp1);
        moveList.add(bike1);
        for (Movable value: moveList){
            System.out.println(value.startMoving());
        }

        List<Person> people= new ArrayList<>();
        people.add(emp1);
        people.add(cust1);
        for (Person value: people){
            System.out.println("name: " + value.getName());
            System.out.print
        }



//        Scanner scanner = new Scanner(System.in);
//        Customer cust1 = new Customer();
//
//        System.out.println("Please enter your name: ");
//        cust1.setName( scanner.nextLine() );
//
//        System.out.println("Please enter your email: ");
//        cust1.setEmail( scanner.nextLine() );
//
//        System.out.println(cust1.toString());

//        System.out.println("nextId = " + Customer.getNextId());

//        List<Customer> customerList = new ArrayList<>();
//        customerList.add(new Customer("Deon", "deon@myco.com"));
//        customerList.add(new Customer("Gabe", "gabe@myco.com"));
//        customerList.add(new Customer("Elana", "elana@myco.com"));
//
//        Customer cust1 = new Customer("David", "dv@myco.com");
//        System.out.println(cust1.toString());
//        System.out.println("Name is " + cust1.getName());
//
//        Customer cust2 = new Customer("Tara", "tv@myco.com");
//        System.out.println(cust2.toString());


//        for (Customer value : customerList){
//            System.out.println(value.toString());
//        }
    }
}
