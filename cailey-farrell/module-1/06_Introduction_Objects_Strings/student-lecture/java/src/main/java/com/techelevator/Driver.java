package com.techelevator;

public class Driver {

    public static void main(String args) {
        int[] grades = {11, 10};
        GradeManager myManager = new GradeManager(grades);
        double averageScore = myManager.averageGrade();
        System.out.println("Average:" + averageScore);
        myManager.printGrades();

    }
}