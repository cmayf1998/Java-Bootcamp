package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter in a series of decimal values (separated by spaces)"); //prints out message

        while (true) {
            String binary = " ";
            int decimal = scanner.nextInt();
            if (decimal <= 0) {
                break;
            }

            int result = decimal;
            while (result > 0) {
                binary = (result % 2) + binary;
                result = result / 2;
            }

            System.out.println(decimal + " in binary is " + binary);
        }
    }
}
