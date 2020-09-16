package com.techelevator.entity;

public abstract class Vehicle implements Moveable {

    private int noOfWheels;

    public Vehicle(){

    }

    public Vehicle(int noOfWheels){
        this.noOfWheels = noOfWheels;
    }

    public int getNoOfWheel(){
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels){
        this.noOfWheels = noOfWheels;
    }



}
