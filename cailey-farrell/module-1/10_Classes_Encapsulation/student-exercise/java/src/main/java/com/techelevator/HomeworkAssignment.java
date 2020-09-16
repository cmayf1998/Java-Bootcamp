package com.techelevator;

public class HomeworkAssignment {
    private int earnedMarks;
    private int possibleMarks;
    private String submitterName;
    private String letterGrade;

    public HomeworkAssignment(int possibleMarks) {
        this.possibleMarks = possibleMarks;
    }

    //Getters and setters:

    public int getEarnedMarks() {
        return earnedMarks;
    }


    public int getPossibleMarks() {
        return possibleMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public void setSubmitterName(String submitterName) {
        this.submitterName = submitterName;
    }

    public String getLetterGrade() {
        int grade = 0;
        grade = (int) (((double) earnedMarks / (double) possibleMarks) * 100);

        if (grade >= 90) {
            return letterGrade = "A";
        } else if (grade >= 80 && grade <= 89) {
           return letterGrade = "B";
        } else if (grade >= 70 && grade <= 79) {
           return letterGrade = "C";
        } else if (grade >= 60 && grade <= 69) {
           return letterGrade = "D";
        } else {
          return letterGrade = "F";
        }
    }
}


