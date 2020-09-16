package com.techelevator.entity;

import java.math.BigDecimal;

public class Employee extends Person implements Moveable{
    private int empNo;

    private String role;

    private BigDecimal salary;
    //big decimal if youre dealing with money

    public Employee() {
    }

    public Employee(String name, String email, int empNo, String role, BigDecimal salary) {
        super(name, email);
        this.empNo = empNo;
        this.role = role;
        this.salary = salary;
    }

    public String startMoving(){
        return "Employee is started...";
    }

    public String move() {
        return "Employee is moving";
    }

    public String stopMoving(){
        return "Employee is stopped";
    }






    //getters and setters
    /*
    Property definitions for the Java Bean Spec
        Property name - drop the get ot set and go to lower case on first letter
        Example: empNo, role, salary
     */
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }


    public Employee(String name, String email) {
        super(name, email);
    }

    @Override
    public String startMoving() {
        return "Employee is started...";
    }

    @Override
    public String move() {
        return "Employee is moving...";
    }

    @Override
    public String stopMoving() {
        return "Employee Stopp";
    }

}