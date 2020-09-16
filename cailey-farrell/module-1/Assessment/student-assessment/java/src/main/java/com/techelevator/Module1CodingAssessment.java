package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {
	private TellerMachine subject;


	public static void main(String[] args) {
		TellerMachine tm1 = new TellerMachine("Acme Machines", new BigDecimal( 1000.00), new BigDecimal(300.00));
		System.out.println(tm1 + " balance: " + tm1.getBalance());
		System.out.println("Number is valid:" + tm1.validCardnumber("599999999"));

	}

	public static List<TellerMachine> getTellerMachineList(){
		List<TellerMachine> list = ArrayList<>();
		try(Scanner scanner = new Scanner(new File(""))) {

		} catch(Exception ex){
			System.out.println("Error opening file!");
		}

		return list;
	}

}
