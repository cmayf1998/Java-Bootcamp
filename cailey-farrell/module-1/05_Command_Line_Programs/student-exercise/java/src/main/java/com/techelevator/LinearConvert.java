package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the length ");
		String value = input.nextLine();
		double length = Integer.parseInt(value);

		System.out.println("Is the measurement in (m)eter, or (f)eet?");
		String value2 = input.nextLine();
		if (value2.equals("m")) {
			double feet = length * 0.3048;
			System.out.println(length + "f is " + feet + "m");
		}

		if (value2.equals("f")) {
			double meters = length * 3.2808399;
			System.out.println(length + "m is " + meters + "f");
		}

	}

}
