package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = 0;
		int b = 1;
		int c;
		int index = 0;
		System.out.print("Please enter a Number: ");

		int value = input.nextInt();
		System.out.print(a + " " + b);
		c = a + b;
		for (int i = 0; i < value; i++) {
			if (c > value)
				break;
			System.out.print(" " + c);
		}


	}

}
