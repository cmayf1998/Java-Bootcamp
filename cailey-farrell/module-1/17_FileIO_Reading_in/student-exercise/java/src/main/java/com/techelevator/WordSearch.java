package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is the file that should be searched ");

		String filePath = scanner.nextLine();
		System.out.println("What is the search word you are looking for?");
		String searchWord = scanner.nextLine();

		System.out.println("Should the search be case sensitive? (Y\\N)");
		String caseLetter = scanner.nextLine();

	File userFile = new File(filePath);
		try(Scanner test = new Scanner(new File (filePath));) {
			int count = 1;

			while (test.hasNextLine()) {
				String newLine = test.nextLine();
				//String newLineLowerCase = filePath.toLowerCase();
				if (caseLetter.equals("N")) {
					searchWord = searchWord.toLowerCase();
					newLine = newLine.toLowerCase();
				}

				if (newLine.contains(searchWord)) {
					System.out.println(count + ") " + newLine);

				}
				count++;
			}


		} catch (FileNotFoundException e){
			System.out.println(e.getMessage());
			e.printStackTrace(System.out);
			System.exit(1);
		}

	}

}
