package com.techelevator.entity;

import java.time.LocalDate;

public class Customer {
    /*
        Define fields of the class - usually set their scope to private (only the methods in this class)
     */
    private static int nextId = 1;

    public static int getNextId(){
        return nextId;
    }

    public static final int DAYS_OF_WEEK = 7;

    private int id; // unique id we generate for all customers

    private String name; // allocated on the Heap (defined in the class outside of any method)

    private String email;

    private LocalDate birthDate;

    /*
        Define the constructors - always same name as class, no return value, unique parameter list
        - if more than 1 example of method overloading
     */
    public Customer(){ // default or no argument constructor - usually you want this in your class
        id = nextId;
        nextId++;
    }

    public Customer(String name, String email){
        this(name, email, null);
    }

    public Customer(String name, String email, LocalDate birthDate){
        id = nextId;
        nextId++;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    /*
        methods - setter and getter
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String toString() {
        return "Customer is " + id + " " + name + " " + email + " " + birthDate;
    }
}
