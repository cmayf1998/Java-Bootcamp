package com.techelevator;

public class Elevator {
    private boolean doorOpen;
    private int numberOfFloors;
    private int currentFloor;

    public Elevator(int totalNumberOfFloors) {
        this.numberOfFloors = totalNumberOfFloors;
        currentFloor = 1;
    }

    //getters:


    public boolean isDoorOpen() {
        return doorOpen;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    //methods:
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!doorOpen) {
            if (desiredFloor <= numberOfFloors && desiredFloor > currentFloor) {
                currentFloor = desiredFloor;
            }
        }
    }

        public void goDown (int desiredFloor){
            if (!doorOpen) {
                if (desiredFloor >= 1 && currentFloor > 1 ) {
                    currentFloor = desiredFloor;
                }
            }
        }
    }
