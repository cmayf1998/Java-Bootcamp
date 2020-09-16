package com.techelevator;

import java.util.*;

public class Lecture {

	public static void printTheCollection(Iterator it){
		while (it.hasNext()){
			System.out.println(it.next());
		}

	}

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		List<String> myList = new ArrayList();
		myList.add("One");
		myList.add("Two");
		myList.add("Three");

		List<Integer> myListOfInts = new ArrayList<>();
		myListOfInts.add( new Integer(9));
		myListOfInts.add(56); // auto boxing - moving a primitive value into it's Wrapper object

		int num = myListOfInts.get(1); // auto unboxing - moving a primitive Wrapper object back to a primitive value

		Stack<String> myStack = new Stack();
		for (String value : myList){
			myStack.push(value);
		}
		System.out.println("####################");
		System.out.println("Popping myStack values");
		System.out.println("####################");
//		for (String value : myStack){
//			System.out.println(value);
//		}
		List<String> revList = new ArrayList(myStack.size());
		while (!myStack.isEmpty()){
			revList.add(myStack.pop());
		}

		for (String value : revList){
			System.out.println(value);
		}

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
//		for (String value : myList){
//			System.out.println(value);
//		}
		printTheCollection(myList.iterator());

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		myList.add("One");
		printTheCollection(myList.iterator());

		System.out.println("####################");
		System.out.println("My Set");
		System.out.println("####################");
		Set<String> mySet = new HashSet();
		mySet.add("One");
		mySet.add("Two");
		mySet.add("One");
		printTheCollection(mySet.iterator());

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		System.out.println("####################");
		System.out.println(" PRIMITIVE WRAPPERS");
		System.out.println("####################");

		/* Every primitive data type has an equivalent "primitive wrapper class" that is an object representation
		 * of a primitive value */

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		System.out.println("####################");
		System.out.println("       QUEUES");
		System.out.println("####################");
		System.out.println();
		LinkedList<String> myQueue = new LinkedList<>();
		boolean isInserted = myQueue.offer("One");
		System.out.println("isInserted: " + isInserted);
		myQueue.offer("Two");
		printTheCollection(myQueue.iterator());
		String el = myQueue.peek();
		System.out.println("el: " + el);
		printTheCollection(myQueue.iterator());

		/////////////////////
		// PROCESSING ITEMS IN A QUEUE
		/////////////////////

		System.out.println("####################");
		System.out.println("       STACKS");
		System.out.println("####################");
		System.out.println();

		////////////////////
		// PUSHING ITEMS TO THE STACK
		////////////////////

		////////////////////
		// POPPING THE STACK
		////////////////////

	}
}
