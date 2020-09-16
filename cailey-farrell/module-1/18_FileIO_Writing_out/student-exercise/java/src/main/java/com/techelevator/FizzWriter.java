package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {

		try(PrintWriter printer = new PrintWriter(new File("FizzBuzz.txt"));){
			List<Integer> numbers = new ArrayList<>();

			for(int i = 1; i <= 300; i++){
				numbers.add(i);
			}

			for(int i = 0; i < numbers.size(); i++){
				if (numbers.get(i)%3 == 0 && numbers.get(i)%5==0){
					printer.println("FizzBuzz");
				} else if (numbers.get(i)%3==0 || Integer.toString(numbers.get(i)).contains("3")) {
					printer.println("Fizz");
				} else if (numbers.get(i)%5==0 || Integer.toString(numbers.get(i)).contains("5")){
					printer.println("Buzz");
				} else {
					printer.println(numbers.get(i));
				}
			}

			System.out.println("FizzBuzz.txt has been created");

		} catch (FileNotFoundException e){
			System.out.println("no such file exists");
		}

	}

}
