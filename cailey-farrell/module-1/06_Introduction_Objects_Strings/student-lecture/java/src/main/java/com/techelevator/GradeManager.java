package com.techelevator;

public class GradeManager {

    int[] grades; //field of the GradeManager class

    //constructors - has same name as class, also note there is no return value
    //used to initialize the fields of our class when we create an object
    public GradeManager(int[] gradesArray){
        grades = gradesArray;
    }

    //method of the GradeManager class
    public double averageGrade() {
        int total = 0;
        // only care about the value
        for (int value : grades) {
            total += value;
        }
        return (double)total/grades.length;
    }
}


