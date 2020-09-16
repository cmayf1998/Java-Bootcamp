package com.techelevator.entity;

import java.time.LocalDate;

public class Customer extends Person { //Customer is a Person, inherits all fields and methods of Person class
    /*
        Define fields of the class - usually set their scope to private (only the methods in this class)
     */
    private static int nextId = 1;

    public static int getNextId(){

        return nextId;
    }

    private static int getNextId(){
        return nextId;
    }

    private int id;

    private LocalDate birthDate;

    /*
        Define the constructors - always same name as class, no return value, unique parameter list
        - if more than 1 example of method overloading
     */


    public Customer(String name, String email){
        this(name, email, null);
    }

    public Customer(String name, String email, LocalDate birthDate){
        super(name, email);
        this.id = nextId;
        nextId++;
        this.birthDate = birthDate;
    }
    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void se


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

        return "Customer is{ " + " : " + super.toString() +
                "id=" + id +
                ", birthDate=" + birthDate + ", name=" + getName()+
                '}';
    }
}
