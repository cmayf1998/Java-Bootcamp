package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter the temperature: ");
		String value = input.nextLine();
		double temp = Integer.parseInt(value);

		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?");
		String value2 = input.nextLine();
		if (value2.equals("C")) {
			double tempCelcius = (temp - 32) / 1.8;
			System.out.println(temp + "F is " + tempCelcius + "C");
		}

		if (value2.equals("F")) {
			double tempFahrenheit = (temp * 1.8) + 32;
			System.out.println(temp + "C is " + tempFahrenheit + "F");

		}
	}
}


