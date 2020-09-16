package com.techelevator;

import com.techelevator.entity.DayOfWeek;
import com.techelevator.entity.MovieFormat;
import com.techelevator.entity.MovieRental;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {

		for (MovieFormat value : MovieFormat.values()){
			System.out.println(value + " : Ordinal is " + value.ordinal());
		}

		MovieRental movieRental =
				new MovieRental("The Visit", MovieFormat.BLURAY, true);
		System.out.println(movieRental);
		System.out.println("Late fee: " + movieRental.getLateFee(2).setScale(2, RoundingMode.HALF_EVEN));

		List<MovieRental> movieList = getMovieList();
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (MovieRental value : movieList){
			totalPrice = totalPrice.add(value.getRentalPrice());
			System.out.println(value);
		}
		System.out.println("Total price: " + totalPrice.setScale(2, RoundingMode.HALF_EVEN));
	}

	public static List<MovieRental> getMovieList(){
		List<MovieRental> movieList = new ArrayList<>();
		try(Scanner scanner = new Scanner( new File(".//data-files/MovieInput.csv"))) {
			while ((scanner.hasNextLine())){
				String[] tokens = scanner.nextLine().split(",");
				movieList.add( new MovieRental(
						tokens[0], MovieFormat.getFormatFromString(tokens[1]), Boolean.parseBoolean(tokens[2])
				));
			}
		} catch (Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
		return movieList;
	}

}
