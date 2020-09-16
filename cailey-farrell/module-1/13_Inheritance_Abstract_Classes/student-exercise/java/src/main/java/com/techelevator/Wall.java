package com.techelevator;

import java.awt.geom.Area;

public abstract class Wall {

    private String name;
    private String color;
    private int totalArea;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Wall(String name, String color){
        this.name = name;
        this.color = color;

    }

    public abstract int getArea();
    //abstract method looks like a statement - no body

}
