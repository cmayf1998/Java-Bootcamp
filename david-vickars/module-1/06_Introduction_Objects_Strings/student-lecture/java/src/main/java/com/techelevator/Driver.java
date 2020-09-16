package com.techelevator;

public class Driver {

    public static void main(String[] args){
        // this is a local variable defined inside the main method block
        int[] grades = {11, 10};
        /*
            the above is a short way of doing the following lines of code:
            int[] grades = new int[2];
            grades[0] = 11;
            grades[1] = 10;
         */

        // 1. Allocate myManager local variable to hold a reference to a GradeManager object.
        //      GradeManager myManager
        // 2. Create new GradeManager object in the heap... call constructor to pass in a reference to the int[] of grades
        //      new GradeManager(grades)
        // 3. Assign the reference received for the new object to the local myManager variable
        //      =
        GradeManager myManager;
        myManager = new GradeManager(grades);
        double averageScore = myManager.averageGrade();
        System.out.println("Average: " + averageScore);
        myManager.printGrades();

        int[] yourGrades = {11, 10, 10, 9, 11, 5};
        GradeManager yourManager = new GradeManager(yourGrades);
        System.out.println("\nAverage: " + yourManager.averageGrade());
        yourManager.printGrades();

        String greeting = "Hello";
        String upperGreeting = greeting.toUpperCase();
    }
}
