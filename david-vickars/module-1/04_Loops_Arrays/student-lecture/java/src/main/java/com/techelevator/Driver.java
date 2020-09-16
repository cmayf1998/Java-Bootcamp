package com.techelevator;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        int num = 42;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your birth year: ");
        int birthYear = Integer.parseInt( scanner.nextLine() );

        System.out.println("Please enter your birth month: ");
        int birthMonth = Integer.parseInt( scanner.nextLine() );

        System.out.println("Your birth day is " + birthYear + "/" + birthMonth);
    }
}
