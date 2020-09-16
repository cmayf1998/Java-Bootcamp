package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {

			Scanner input = new Scanner(System.in);
			System.out.print("What is the java file that should be searched?: ");
			String userInput = input.nextLine();
			System.out.print("What is the search word you are looking for?: ");
			String searchWord = input.nextLine();
			System.out.println("What word do you want to replace the search word with: ");
			String replacementWord = input.nextLine();


			File myFile = new File(userInput);
			File outputFile = new File("Test.txt");
			try (Scanner scanner = new Scanner(myFile); PrintWriter text = new PrintWriter(outputFile);) {
				while(scanner.hasNext()){
					String lineOfInput = scanner.nextLine();
					if (lineOfInput.contains(searchWord)){
						lineOfInput = lineOfInput.replace(searchWord, replacementWord);
					}
					text.write(lineOfInput);
				}
			} catch (FileNotFoundException e) {
				System.out.println("invalid destination file" + e.getMessage());
				e.printStackTrace();
				System.exit(1);
			}


		}

	}
