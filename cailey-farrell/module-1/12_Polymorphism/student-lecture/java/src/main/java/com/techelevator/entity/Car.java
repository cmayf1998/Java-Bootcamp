package com.techelevator.entity;

public class Car extends Vehicle {

    private String engine;

    public Car(){}

    public Car(int noOfWheels, String engine){
        super(noOfWheels);
        this.engine = engine;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
