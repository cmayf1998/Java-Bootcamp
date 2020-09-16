package com.techelevator.dog;

public class Dog {
    private boolean isSleeping;

    public void sleep(){
        isSleeping = true;
    }
    public void wakeUp() {
        isSleeping = false;
    }
    public boolean isSleeping() {
        return isSleeping;
    }

    public String makeSound () {
        if (isSleeping) {
            return "Zzzzz...";
        } else {
            return "Woof!";
        }
    }

}
