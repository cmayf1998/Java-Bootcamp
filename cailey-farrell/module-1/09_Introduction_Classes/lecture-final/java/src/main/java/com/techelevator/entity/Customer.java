package com.techelevator.entity;

public class Customer {
    /* Definte fields of the class - usually set their scope to private (only the methods in this class)

     */

    private String name; //allocated on the Heap (in the class outside of any method)
    private String email;

    /* Definte the constructors - always same name as class, no return value, unique parameter list
    -if more than 1 example of method overloading
     */
    public Customer() { //default or no argument constructor - usually you want this for your class
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /*
    methods - setter and getter
     */
    public String getName(){ //naming convention always with get then name of the field with capital first letter
        return name;
    }
    public void setName(String name) {
        //protected the field if you want.. check the name passes in is not null
        this.name = name;
    }
}
