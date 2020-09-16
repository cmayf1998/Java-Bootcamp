package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(new File("alices_adventures_in_wonderland.txt"));) {
			int countWords = 0;
			int countSentences = 0;
			while (scanner.hasNext()) {
				String[] words = scanner.next().split(" ");
				countWords++;

				for (int i = 0; i < words.length; i++) {
					if (words[i].contains(".") || words[i].contains("!") || words[i].contains("?")) {
						countSentences++;
					}
				}
			}
			System.out.println(countWords);
			System.out.println(countSentences + "*");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}