package lab10;

import java.io.*;
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Main class for CS206 Lab 10. Student must complete three methods: 1) pqInt 2)
 * pqNameMin 3) pqNameMax
 *
 * For Lab 10, student must also complete the compareTo method in the NameMin
 * and NameMax classes.
 * 
 * @author Rose Reiner
 */
public class Lab10 {

	/**
	 * DO NOT MODIFY THIS METHOD
	 *
	 * Main method for Lab 10.
	 */
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("calling pqInt method...");
		pqInt("ThousandInts.txt", 20);

		System.out.println("\ncalling pqNameMin method...");
		pqNameMin("NameList.txt", 15);

		System.out.println("\ncalling pqNameMax method...");
		pqNameMax("NameList.txt", 15);

		// Testing parse
		// String test = "72 Carl";
		//
		// int test2 = Integer.parseInt(test.substring(0, 2));
		// String test3 = test.substring(3, test.length());
		// System.out.println(test2);
		// System.out.println(test3);

	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD Follow the steps outlined by the
	 * comments to complete this method.
	 *
	 * Uses a Priority Queue to print the given number of lowest integers that
	 * are read from the given file.
	 *
	 * @param filename
	 *            The pathname of the input file
	 * @param numItems
	 *            The number of items to print
	 */
	public static void pqInt(String filename, int numItems) throws FileNotFoundException {

		// A priority queue that contains integers. The lowest integer value
		// will have the highest priority (will be removed first).
		PriorityQueue<Integer> pqInt = new PriorityQueue<Integer>();

		// Read integers from the file specified by the filename parameter. Add
		// each integer to the pqInt priority queue.
		readFileInt("ThousandsInts.txt", pqInt);

		// Print the first numItems that are removed from the priority queue.
		for (int i = 0; i < numItems; i++) {
			System.out.println("Lowest 20 items in file: " + pqInt.poll());
		}
	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD Follow the steps outlined by the
	 * comments to complete this method.
	 *
	 * Uses a Priority Queue to print the given number of (name priority) pairs
	 * that are read from the given file, where the lowest value for priority is
	 * the first item removed from the priority queue.
	 *
	 * @param filename
	 *            The pathname of the input file
	 * @param numItems
	 *            The number of items to print
	 *
	 */
	public static void pqNameMin(String filename, int numItems) throws FileNotFoundException {

		// A priority queue that contains NameMin objects.
		PriorityQueue<NameMin> pqName = new PriorityQueue<NameMin>();

		// Read the input file and create a NameMin object for each line of the
		// input file. Add each NameMin object to the pqName priority queue.

		readFileName("NameList.txt", pqName);
		// Print the first numItems that are removed from the priority queue.

		for (int i = 0; i < numItems; i++) {
			NameMin firstOff = pqName.poll();
			System.out.println(firstOff.getName() + " " + firstOff.getPriority());
		}

	}

	/**
	 * STUDENT MUST COMPLETE THIS METHOD Follow the steps outlined by the
	 * comments to complete this method.
	 *
	 * Uses a Priority Queue to print the given number of (name priority) pairs
	 * that are read from the given file, where the highest value for priority
	 * is the first item removed from the priority queue.
	 *
	 * @param filename
	 *            The pathname of the input file
	 * @param numItems
	 *            The number of items to print
	 *
	 */
	public static void pqNameMax(String filename, int numItems) throws FileNotFoundException {

		// A priority queue that contains NameMax objects.
		PriorityQueue<NameMax> pqName = new PriorityQueue<NameMax>();

		// Read the input file and create a NameMax object for each line of the
		// input file. Add each NameMax object to the pqName priority queue.

		readFileName2("NameList.txt", pqName);

		// Print the first numItems that are removed from the priority queue.
		for (int i = 0; i < numItems; i++) {
			NameMax firstOff = pqName.poll();
			System.out.println(firstOff.getName() + " " + firstOff.getPriority());
		}

	}

	/**
	 * Reads from the input file 
	 * 
	 * @param inFile
	 *            The pathname of the input file to read from
	 * @param pqName
	 *            The priority queue to add names and priority to
	 */
	public static void readFileInt(String inFile, PriorityQueue<Integer> pqInt) throws FileNotFoundException {

		File a = new File(inFile);
		// System.out.println(a.getAbsolutePath());
		Scanner console = new Scanner(a);
		int numbers;
		while (console.hasNextLine()) {
			numbers = console.nextInt();
			// System.out.println(numbers);
			pqInt.add(numbers); // add the int values from the file into the
								// priority queue
		}

	}

	/**
	 * Reads from the input file 
	 * 
	 * @param inFile
	 *            The pathname of the input file to read from
	 * @param pqName
	 *            The priority queue to add names and priority to
	 */
	public static void readFileName(String inFile, PriorityQueue<NameMin> pqName) throws FileNotFoundException {
		File fileName = new File(inFile);
		Scanner console = new Scanner(fileName);
		int priority = 1; // change this later
		String line1;

		while (console.hasNextLine()) {
			line1 = console.nextLine();

			// formatting
			int test2 = Integer.parseInt(line1.substring(0, 2).trim());
			// System.out.println("test p: " + test2);
			String nameOnly = line1.substring(2, line1.length());

			NameMin names = new NameMin(nameOnly, test2);
			pqName.add(names);

		}
	}

	/**
	 * Reads from the input file 
	 * 
	 * @param inFile
	 *            The pathname of the input file to read from
	 * @param pqName
	 *            The priority queue to add names and priority to
	 */
	public static void readFileName2(String inFile, PriorityQueue<NameMax> pqName) throws FileNotFoundException {
		File fileName = new File(inFile);
		Scanner console = new Scanner(fileName);
		// int priority = 1;
		String line1;

		while (console.hasNextLine()) {
			line1 = console.nextLine();

			// formatting
			int test2 = Integer.parseInt(line1.substring(0, 2).trim());
			String nameOnly = line1.substring(2, line1.length());

			NameMax names = new NameMax(nameOnly, test2);
			pqName.add(names);

		}
	}

}