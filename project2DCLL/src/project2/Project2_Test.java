package project2;

/**
 * @author Rose Reiner and Mara Greene
 * @version 1.0
 *
 */

public class Project2_Test {
	/**
	 * Test program to make sure all the methods in the doubly and circularly
	 * linked list are implemented correctly
	 */
	public static void main(String[] args) {
		// Create different types of objects
		int x = 1;
		int y = 2;
		int z = 3;
		String s = "a, b, c";
		String d = "d, e, f";
		String b = "g, h, i";
		// Test 1: Test the DLLNode class
		// To show that the DLLNode class to be completed
		System.out.println("Starting Test One (DLLNode test)");

		DLLNode<Integer> n1 = new DLLNode<Integer>(x);
		DLLNode<Integer> n2 = new <Integer>DLLNode(y);
		DLLNode<Integer> n3 = new <Integer>DLLNode(z);
		DLLNode<String> n4 = new <String>DLLNode(s);
		DLLNode<String> n5 = new <String>DLLNode(d);

		// The getNext and getPrevious methods should return null
		if (n1.getNext() != null) {
			System.out.println("FAIL: getNext should be null");
		}
		if (n1.getPrevious() != null) {
			System.out.println("FAIL: getNext should be null");
		}

		// The getData method should return a reference to the same object as n1
		// refers to
		if (n4.getData() != s) {
			System.out.println("FAIL: n1.getData should return reference to b1");

		}

		// Test the setNext and setPrevious methods
		n1.setPrevious(n2);
		n1.setNext(n3);
		if (n1.getPrevious() != n2) {
			System.out.println("FAIL: n1.getPrevious should return reference to n2");

		}
		if (n1.getNext() != n3) {
			System.out.println("FAIL: n1.getNext should return reference to n3");
		}

		// Test the setData method
		n1.setData(x);
		if (n1.getData() != x) {
			System.out.println("FAIL: After calling setData, n1.getData should return reference to x");
		}
		System.out.println("Finished Test 1");
	

		// Prepare for testing the BookDLL methods
		// Construct a doubly linked list

		DLLNode<String> ns1 = new DLLNode<String>("Hello");

		// Add three objects to the list
		DCLL<String> sList = new DCLL<String>();
		sList.add("Computer");
		sList.add("Science");
		sList.add("class");
		
		//Seeing how many items are in the list 
		System.out.println();
		System.out.println("The size of the list should be 3");
		System.out.println("The size of the list is: " + sList.size());
		System.out.println();

	

		// Test 2: Test the methods that return the title lists forwards
		System.out.println("Starting Test 2(title list methods forwards)...");

		String forwardPrint = sList.forwardString();
		String forwardTest = "Computer, Science, class";
		if (!forwardPrint.equals(forwardTest)) {
			fail("Forward string is not correct");
		} else {
			System.out.println("Finished Test 2");
			System.out.println();
		}

		// Test 3: Test the methods that return the title lists backwards
		System.out.println("Starting Test 3(title list methods backwards)...");

		String backwardPrint = sList.reverseString();
		String backwardTest = "class, Science, Computer";
		if (!backwardPrint.equals(backwardTest)) {
			fail("Backward string is not correct");
		} else {
			System.out.println("Finished Test 3");
			System.out.println();
		}

		// Test 4: clear
		System.out.println("Starting Test 4.....(clear)");
		sList.clear();

		if (sList.size() != 0) {
			fail("list size is not zero");
		} else {
			System.out.println("Finish Test 4");
			System.out.println();
		}

		// Test 5: Empty
		System.out.println("Starting Test 5....(isEmpty)");
		if (sList.isEmpty()) {
			System.out.println("Finish Test 5");
			System.out.println();
		} else {
			fail("is not empty");
		}

		// Test 6: Set
		System.out.println("Starting Test 6...(set)");
		sList.add("hi");
		sList.add("hello");
		sList.add("goodbye");

		sList.set(1, "hey");
		if (!sList.get(1).equals("hey")) {
			fail("they are not equal");
		} else {
			System.out.println("Finish Test 6");
			System.out.println();
		}

		// Test 5: Contains
		System.out.println("Starting Test 5....(contains)");
		if (sList.contains("hey")) {
			System.out.println("Finish Test 5");
			System.out.println();

		} else {
			fail("List does not contain hey");
		}

		// Test 6: IndexOf
		System.out.println("Starting Test 6.....(IndexOf)");
		if (sList.indexOf("hey") != 1) {
			fail("is not the right index");

		}
		if (sList.indexOf("random") != -1) {
			fail("should not be in the list");
		}
		System.out.println("Finished Test 6");
		System.out.println();

		// Test 7: lastIndexOf
		System.out.println("Starting Test 7.....(lastIndexOf)");
		// System.out.println(sList.forwardString());
		if (sList.lastIndexOf("goodbye") != 2) {
			fail("is not the right index");
		}
		if (sList.lastIndexOf("random") != -1) {
			fail("should not be in the list");
		}
		System.out.println("Finish Test 7");
		System.out.println();

		// Test 8: remove (index)
		System.out.println("Starting Test 8 (remove index)");

		if (!sList.remove(1).equals("hey")) {
			fail("should be index 1");
		}

		if(!sList.remove(0).equals("hi")){
			fail("should be index 0");
		}
		sList.add(0, "hi");
		System.out.println("Finish Test 8");
		System.out.println();

		
		//Test 9: remove (object)
		System.out.println("Starting Test 9: (remove object)");
		if(!sList.remove("goodbye")){
			fail("is in the list");
		}
		if(sList.remove("random")){
			fail("not in the list");
		}
		
		if(!sList.remove("hi")){
			fail("is in the list");
		}
		
		sList.add(0, "hi");
		System.out.println("Finish Test 9");
		System.out.println();
		
		//Test 10: Add (element)
		System.out.println("Starting Test 10 (add element)");
		sList.add("what's up");
		if(!sList.get(2).equals("what's up")){
			fail("should be in list");
		}else{
			System.out.println("Finish Test 10");
			System.out.println();
		}
		
		//Test 11: Add (index)
		System.out.println("Starting Test 11 (add at index)");
		sList.add(1, "CS");
		
		if(!sList.get(1).equals("CS")){
			fail("should be CS");
		}else{
			System.out.println("Finish Test 11");
			System.out.println();
		}
		
		//Test 12: Size; sees the size of the list at the end 
		System.out.println("The size of the list is: " + sList.size());
		

	}

	/**
	 * Prints "FAIL:" followed by the message passed as a parameter.
	 *
	 * @param s
	 *            A message to print
	 */
	public static void fail(String s) {
		System.out.println("FAIL: " + s);
	}

}
