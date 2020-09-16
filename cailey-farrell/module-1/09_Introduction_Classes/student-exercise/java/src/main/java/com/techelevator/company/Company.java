package com.techelevator.company;

public class Company {
    private String name;
    private Integer numberOfEmployees;
    private Double revenue;
    private Double expenses;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public double getRevenue() {
        return revenue;
    }

    public double getExpenses() {
        return this.expenses;
    }

    public String getCompanySize() {
        if (numberOfEmployees <= 50) {
            return "small";
        }
        if (numberOfEmployees >= 51 && numberOfEmployees <= 250) {
            return "medium";
        } else return "large";
    }

    public double getProfit () {
        double result = revenue - expenses;
        return result;
    }

}
