package com.techelevator;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your birth year: ");

        String birthYear = scanner.nextLine();
        System.out.println("Your birth year is "+ birthYear);

    }
}
