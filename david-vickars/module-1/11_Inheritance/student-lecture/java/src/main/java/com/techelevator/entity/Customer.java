package com.techelevator.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Customer extends Person { // Customer is a Person inherits all fields and methods of Person class
    /*
        Define fields of the class - usually set their scope to private (only the methods in this class)

        P I E - 3 general principals of OO language
     */
    private static int nextId = 1;

    public static int getNextId(){
        return nextId;
    }

    private int id; // unique id we generate for all customers

    private LocalDate birthDate;

    public Customer(){
        this(null, null, null);
    }

    public Customer(String name, String email, LocalDate birthDate) {
        super(name, email); // call to Person constructor... must be the first line!
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

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer{" + " : " + super.toString() +
                " id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, birthDate);
    }
}
