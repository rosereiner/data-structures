package project2;

/**
 * A class that implements methods for the doubly circularly linked list
 * @author Rose Reiner and Mara Greene
 * @version 1.0
 */
import java.util.*;

public class DCLL<T> {

	/**
	 * A reference to the first node in the list
	 */
	private DLLNode<T> head;

	/** A reference to the last node in the linked list */
	private DLLNode<T> tail;

	
	
	/**
	 * Constructs an empty list
	 */
	public DCLL() {
		head = null;
		tail = null;
	}

	/**
	 * Returns the size of this list
	 * 
	 * @return The size of this list
	 */

	public int size() {
		if (head == null) {
			return 0;
		}

		int count = 0;
		DLLNode<T> temp = head;

		do {
			temp = temp.getNext();
			count++;
		} while (temp != head);

		return count;
	}

	/**
	 * Returns the element found at index i and does not alter the list.
	 * 
	 * @param i
	 *            The index of the desired element
	 * @return The element found at index i
	 * @throws IndexOutOfBounds
	 *             Exception if i is less than zero or greater than (list size -
	 *             1)
	 */
	public T get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size() - 1) {
			throw new IndexOutOfBoundsException("index is not valid");
		}
		DLLNode<T> temp = head;
		int count = 0;

		while (temp.getNext() != head && count < i) {
			temp = temp.getNext();
			count++;
		}
		return temp.getData();

	}

	/**
	 * Appends the specified object to the end of this list
	 * 
	 * @o The object data to place at the end of this list
	 */

	public boolean add(T o) {
		DLLNode n = new DLLNode(o);

		if (head == null) {
			head = n;
			head.setNext(head);
			head.setPrevious(head);
			return true;
		}
		DLLNode<T> prev = head.getPrevious();
		prev.setNext(n);
		n.setNext(head);
		n.setPrevious(prev);
		head.setPrevious(n);

		return true;
	}

	/**
	 * Returns a String in order.
	 * 
	 * @return String representation of the strings in forward order
	 */
	public String forwardString() {
		DLLNode temp = head;
		String string = ""; // create an empty string for the data in the nodes

		for (int i = 0; i < this.size(); i++) {
			string += temp.getData().toString();
			temp = temp.getNext();
			if (i != this.size() - 1) {
				string += ", ";
			}
		}

		return string;
	}

	/**
	 * Returns a String backwards
	 * @return String representation of the strings in backwards order
	 */
	public String reverseString() {
		DLLNode temp = head.getPrevious();
		String string = "";

		for (int i = 0; i < this.size(); i++) {
			string += temp.toString();
			temp = temp.getPrevious();
			if (i != this.size() - 1) {
				string += ", ";
			}
		}

		return string;
	}

	/**
	 * Inserts the object at the given index. Shifts the object currently at
	 * that position and any other objects to the right
	 * 
	 * @param i
	 *            The index where the object should be inserted
	 * @param b
	 *            The object to insert into the list
	 * @throws IndexOutOfBoundsException
	 *             if the index is less than zero or greater than list size
	 */
	public void add(int i, T b) throws IndexOutOfBoundsException {
		if (i < 0 || i > this.size()) {
			throw new IndexOutOfBoundsException("index not valid");
		}

		int count = 0;
		DLLNode<T> current = head;
		DLLNode<T> newNode = new DLLNode(b);

		// Special case for the first node
		if (i == 0) {
			newNode.setNext(head);
			newNode.setPrevious(head.getPrevious());
			head.getPrevious().setNext(newNode);
			head.setPrevious(newNode);
			head = newNode;
			return;
		}

		// Traverse the list to the position where insert will occur
		while (count < i) {
			current = current.getNext();
			count++;
		}

		// Insert the node
		if (current != head) {
			newNode.setNext(current);
			newNode.setPrevious(current.getPrevious());
			current.getPrevious().setNext(newNode);
			current.setPrevious(newNode);
		}

	}

	/**
	 * Removes all elements from the list. The list will be empty after this
	 * method returns.
	 */
	public void clear() {
		head = null;
	}

	/**
	 * If the list is empty
	 */
	public boolean isEmpty() {
		return (head == null);

	}

	/**
	 * Replaces the element at the specified position in the list with a specified elemtn
	 * @param i index of element to replace
	 * @return the element previously at the specified position
	 */
	public T set(int index, T element) {
		T out = null;

		DLLNode<T> temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		out = temp.getData();
		temp.setData(element);

		return out;

	}

	/**
	 * Returns true if the list contains the special element
	 * @param a element whose presence in this list is to be tested
	 * @return The element found at index i
	 */
	public boolean contains(T a) {
		DLLNode current = head;

		if (current.getData().equals(a)) {
			return true;
		} else {
			current = current.getNext();
		}
		while (current != head) {
			if (a.equals(current.getData())) {
				return true;
			}
			current = current.getNext();
		}
		return false;

	}

	/**
	 * Returns the index of the first occurrence of the specified element
	 * Returns -1 if the list doesn't contain the element
	 * @param o the element to search for
	 */

	public int indexOf(T r) {
		DLLNode current = head;
		int count = 0;

		if (current.getData().equals(r)) {
			return count;
		} else {
			current = current.getNext();
			count++;
		}
		while (current != head) {
			if (r.equals(current.getData())) {
				return count;
			}
			current = current.getNext();
			count++;

		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element 
	 * Returns -1 if the element is not in the list
	 * @param w the element to search for
	 */

	public int lastIndexOf(T w) {
		DLLNode current = head.getPrevious();
		int count = this.size() - 1;

		if (current.getData().equals(w)) {
			return count;
		} else {
			current = current.getNext();
			count--;
		}
		while (current != head.getPrevious()) {
			if (w.equals(current.getData())) {
				return count;
			}
			current = current.getPrevious();
			count++;
		}
		return -1;
	}

	/**
	 * Removes the element at the specified position in the list and shifts the
	 * elements to the left Returns the element that was removed from the list
	 * @param i the index of the element to be removed
	 */

	public T remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= this.size()) {
			throw new IndexOutOfBoundsException("index not valid");
		}

		DLLNode<T> current = head;
		DLLNode<T> previous = head;
		
		if(i == 0){
			head.getPrevious().setNext(head.getNext());
			head.getNext().setPrevious(head.getPrevious());
			head = head.getNext();
		}

		for (int x = 0; x < i; x++) {
			current = current.getNext();

		}
		current.getPrevious().setNext(current.getNext());
		current.getNext().setPrevious(current.getPrevious());

		return current.getData();
	}
	
	/**
	 * Removes the first occurrence of the specified object in the list
	 * If the list does not contain the object, the list is unchanged
	 * Removes element with the lowest index
	 * @param o the object to be removed
	 */
	
	public boolean remove(T o) {
		DLLNode<T> current = head;
		DLLNode<T> previous = head;
		
		if(o.equals(head.getData())){
			head.getPrevious().setNext(head.getNext());
			head.getNext().setPrevious(head.getPrevious());
			head = head.getNext();
		}
		
		
		if(current.getData().equals(o)){
			return true;
		} else{
			current = current.getNext();
		}
		
		while(current != head){
			if(o.equals(current.getData())){
				return true;
			}
			current = current.getNext();
		}
		return false;
		
	}
	
	
	

}
