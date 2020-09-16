package com.techelevator;


import com.techelevator.entity.TellerMachine;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		TellerMachine tm1 = new TellerMachine(
				"Moe's LTD",
				new BigDecimal(750),
				new BigDecimal(400));
		System.out.println(tm1);
		System.out.println("Valid card is " + tm1.isValidCardNumber("5999999999999999"));

		BigDecimal totalBalance = BigDecimal.ZERO;
		List<TellerMachine> tellerMachinesList = getTellerMachineList();
		for (TellerMachine value : tellerMachinesList){
			System.out.println(value);
			totalBalance = totalBalance.add(value.getBalance());
		}
		System.out.println("Total balance: " + totalBalance);
	}

	public static List<TellerMachine> getTellerMachineList(){
		List<TellerMachine> list = new ArrayList<>();
		try (Scanner scanner = new Scanner( new File(".\\data-files\\TellerInput.csv"))){
			while (scanner.hasNextLine()){
				String[] tokens = scanner.nextLine().split(",");
				TellerMachine tm = new TellerMachine(
						tokens[0], new BigDecimal(tokens[1]), new BigDecimal(tokens[2])	);
				list.add(tm);
			}
		} catch (Exception ex){
			System.out.println("Error opening file!");
		}
		return list;
	}

}
