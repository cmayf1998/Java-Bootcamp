package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		// probably would be data from a file or database
		int[] teoGrades = new int[2];
		teoGrades[0] = 11;
		teoGrades[1] = 10;

		int[] adamGrades = {11, 10, 10, 11, 9};
		int[] taraGrades = {12, 8, 9, 10, 11};

		System.out.println("####################");
		System.out.println("       MAPS");
		System.out.println("####################");
		System.out.println();

		/* Map is an interface and HashMap is a class that implements Map */
		Map<String, int[]> myMap = new HashMap<>();

		List<String> myList = new ArrayList<>();
		myList = new Stack<>();

		/* The "put" method is used to add elements to a Map */
		myMap.put(args[0], teoGrades);
		myMap.put(args[1], adamGrades);
		myMap.put(args[2], taraGrades);

		/* The "get" method is used to retrieve elements from a Map */
		int[] adamStuff = myMap.get(args[1]);
		System.out.println("adamStuff: " + adamStuff);

		int[] oldValues = myMap.put(args[1], teoGrades);
	
		/* keySet returns a Set of all of the keys in the Map */
		Set<String> keySet = myMap.keySet();
		for (String key : keySet){
			System.out.println("key: " + key);
		}
		Iterator keys = myMap.keySet().iterator();
		while (keys.hasNext()){
			int[] values = myMap.get(keys.next());
			for (int value : values) {
				System.out.println(value);
			}
		}
		System.out.println("####################");
		System.out.println("       All The values");
		System.out.println("####################");
		System.out.println();

		Iterator allTheValues = myMap.values().iterator();
		while (allTheValues.hasNext()){
			System.out.println("Value: " + allTheValues.next());
		}
		
		/* If the key already exists, put will overwrite the existing value with the new value */


		System.out.println("####################");
		System.out.println("       SETS");
		System.out.println("####################");
		System.out.println();



		System.out.println("####################");
		System.out.println("Sets cannot contain duplicates");
		System.out.println("####################");
		System.out.println();


		System.out.println("####################");
		System.out.println("Sets do not guarantee ordering");
		System.out.println("####################");
		System.out.println();



	}

}
