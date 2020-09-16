package com.techelevator.entity;

public class Bike extends Vehicle {


    private String typeOfPeddles;

    public Bike(){

    }

    public Bike(String typeOfPeddles){
        super(noOfWheels);
        this.typeOfPeddles = typeOfPeddles;
    }

    public String startMoving(){
        return "Bike is started...";
    }

    public String move() {
        return "Bike is moving";
    }

    public String stopMoving(){
        return "Bike is stopped";
    }


}
