package com.techelevator;

public class GradeManager {

    /*
        If you do NOT see the static modifier on a field or method it is an instance field or method
    */

    int[] grades; // instance field of the GradeManager class

    // constructors - has same name as class, also note there is no return value
    // used to initialize the fields of our class when we create an object
    public GradeManager(int[] gradesArray){
        grades = gradesArray;
    }
/*
Instance methods ... created for each object
 */

    // method of the GradeManager class
    public double averageGrade(){
        int total = 0;
        for (int value : grades){
            total += value;
        }
        return (double)total/grades.length;
    }

    public void printGrades(){
        for (int value : grades){
            System.out.print(" " + value);
        }
    }
}
