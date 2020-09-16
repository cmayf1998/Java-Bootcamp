package com.techelevator.entity;

/*
    A Customer is a Tech Connect participant
 */
public class Customer {
    /*
        Define fields of the class - usually set their scope to private (only the methods in this class)
     */
    private String name; // allocated on the Heap (defined in the class outside of any method)

    private String email;

    Transaction lastTransaction;

    /*
        Define the constructors - always same name as class, no return value, unique parameter list
        - if more than 1 example of method overloading
     */
    public Customer(){ // default or no argument constructor - usually you want this in your class

    }

    public Customer(String name, String email){
        this.name = name;
        this.email = email;
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

    public Transaction getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(Transaction lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
}
