package com.techelevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		List<String> myList = new ArrayList();
		myList.add("One");
		myList.add("Two");
		myList.add("Three");

		Stack <String> myStack = new Stack();
		for (String value : myList) {
			myStack.push(value);
		}

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		for (String value : myList) {
			System.out.println(value);
		}

		Iterator it = myList.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");
		mySet.add("One");
		mySet.add("Two");

		Set<String>
		mySet

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
		System.out.println("isInserted:" + isInserted);
		myQueue.offer("Two");
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
