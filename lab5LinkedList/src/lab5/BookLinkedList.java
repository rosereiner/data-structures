package lab5;

/**
* Represents a linked list that contains Book objects.
*
* @author Christine Reilly and Rose Reiner. Collaborated with Kinser Bonner
*/

import java.util.*;

public class BookLinkedList {

	/** A reference to the first node in the Linked List */
	private Node head;

	/**
	 * Constructs an empty list.
	 */
	public BookLinkedList() {
		head = null;
	}

	/**
	 * Returns the size of this list.
	 *
	 * @return The size of this list.
	 */
	public int size() {
		int count = 0; // Number of objects in the list

		Node temp = head; // Reference to the current node

		while (temp != null) {
			// Increment the count of objects in the list
			count++;

			// Set temp to the next node in the list
			temp = temp.getNext();
		}
		return count;
	}

	/**
	 * Appends the specified Book to the end of this list.
	 *
	 * @b The Book to place at the end of this list.
	 */
	public boolean add(Book b) {
		// create a new node
		Node n = new Node(b);

		if (head == null) {
			// list is empty
			head = n;
		} else {
			// list is not empty
			// Traverse the list until the last node is found
			Node temp = head;

			while (temp.getNext() != null) {
				// There is another node after the current one.
				// Set temp to the next node in the list.
				temp = temp.getNext();
			}
			// Now temp is the last node in the list. Update temp so that
			// the new node is added to the list.
			temp.setNext(n);
		}

		return true;
	}

	/**
	 * Inserts the book at the given index. Shifts the book currently at that
	 * position, and any subsequent Books, to the right.
	 *
	 * @param i
	 *            The index where the book should be inserted.
	 * @param b
	 *            The Book object to insert into this list.
	 * @throws IndexOutOfBoundsException
	 *             if index is less than zero or greater than list size
	 */
	public void add(int i, Book b) throws IndexOutOfBoundsException {
		// Check that i is greater than 0 and less than the current number of
		// elements in this list.
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("index is not valid");
		}

		int count = 0; // current position in the list
		Node current = head; // current node in the list
		Node prev = null; // previous node in the list
		Node newNode = new Node(b); // new node containing the Book parameter

		// Traverse the list to the position where the insert will occur
		while (count < i) {
			// Set the previous node to be the current node
			prev = current;

			// Update the current node to be the next node
			current = current.getNext();

			// Add 1 to the count of node
			count++;
		}

		// Insert the node

		// First, set the previous node to reference the new node.
		// If this insert is at the beginning of the list, update head.
		if (prev == null) {
			// inserting at the beginning of the list
			head = newNode;
		} else {
			// The previous node's next references the new node
			prev.setNext(newNode);
		}

		// Second, set the new node's next to reference the next node ina
		// the list. If this insert is at the end of the list, leave next set
		// to null.

		// The new node's next references the current node
		newNode.setNext(current);
	}

	/**
	 * Prints the title of each book in the list.
	 */
	public void printTitles() {
		// Traverse the list
		// Print the title of each book
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.getData().getTitle() + ", ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	/**
	 * LAB 5: Student must complete this method
	 *
	 * Returns the element found at index i. Does not alter the list.
	 *
	 * @param i
	 *            The index of the desired element.
	 * @return The element found at index i
	 * @throws IndexOutOfBoundsException
	 *             if i is less than zero or greater than (list size - 1)
	 */
	public Book get(int i) throws IndexOutOfBoundsException {
		// add code to this method
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("not valid");
		}
		int count = 0; // current position in the list
		Node current = head; // current node in the list

		// Traverse the list to the position where the insert will occur
		while (count < i) {

			// Update the current node to be the next node
			current = current.getNext();

			// Add 1 to the count of node
			count++;
		}
		return current.getData();
	}

	/**
	 * LAB 5: Student must complete this method
	 *
	 * Returns true if the list contains the specified element.
	 *
	 * @return true if the list contains the specified element.
	 */
	public boolean contains(Book b) {
		// add code to this method

		Node current = head; // current node in the list

		// Traverse the list to the position where the insert will occur
		while (current != null) {
			if (b.equals(current.getData())) { //checks if the Book object b has the node
				return true;
			}
			current = current.getNext(); //keeps moving through the list
		}
		return false;
	}

	/**
	 * LAB 5: Student must complete this method
	 *
	 * Removes and returns the first Book from this list.
	 *
	 * @return The book removed from this list.
	 * @throws NoSuchElementException
	 *             if the list is empty
	 */
	public Book removeFirst() throws NoSuchElementException {
		// add code to this method
		
		// get data from the first node
		Book removed = head.getData();
		// Update the current node to be the next node
		head = head.getNext();

		return removed;
	}

	/**
	 * LAB 5: Student must complete this method
	 *
	 * Removes and returns the last Book from this list.
	 *
	 * @return The book removed from this list.
	 * @throws NoSuchElementException
	 *             if the list is empty
	 */
	public Book removeLast() throws NoSuchElementException {
		// add code to this method

		Node current = head;
		Node previous = head;
		while (current.getNext() != null) {
			previous = current; //current is one step further than previous
			current = current.getNext(); //keep moving through the list of nodes

		}

		Book removeLast = current.getData(); //remove the last node and get the data 
		previous.setNext(null); //set previous to be the last node in the list
		return removeLast;
	}

	/**
	 * LAB 5: Student must complete this method
	 *
	 * Removes and returns the Book from this list at the specified index.
	 *
	 * @return The Book that was removed from this list.
	 * @throws IndexOutOfBoundsException
	 *             if i is less than zero or greater than (list size - 1)
	 */
	public Book remove(int i) throws IndexOutOfBoundsException {
		
		// add code to this method
		Node current = head;
		Node previous = head;
		Book removeNode = null;
		
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("invalid index");
		}
	
		if(i == 0){
			return removeFirst(); 
		}
		
		for (int count = 0; count < i; count++) {
			previous = current; //keep current one step ahead of previous
			current = current.getNext();
		}

		removeNode = current.getData();
		previous.setNext(current.getNext());

		return removeNode;

	}

	/**
	 * LAB 5: Student must complete this method
	 *
	 * Removes all elements from this list. The list will be empty after this
	 * method returns.
	 */
	public void clear() {
		// add code to this method
		head = null; //make the head null so there's not a pointer in the list and the list clears

	}

}
