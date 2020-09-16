package com.techelevator;

public class FruitTree {
    private int piecesOfFruitLeft;
    private String typeOfFruit;


    public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //getters and setters
    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }

//methods:

    public boolean pickFruit(int numberOfPiecesToRemove) {
        if (piecesOfFruitLeft < numberOfPiecesToRemove) {
            return false;
        } else {
            piecesOfFruitLeft = piecesOfFruitLeft-numberOfPiecesToRemove;
            return true;
        }
    }

}
