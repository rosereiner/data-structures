package project2;
/**
 * A class that constructs a DLLNode
 * @author Rose Reiner
 * @version 1.0
 * @param <T> refers to any object
 */

public class DLLNode<T> {
	//T can be any object
	
	/** The data contained in this node */
	private T data;
	
	/**A reference to the next node in the list*/
	private DLLNode<T> next;
	
	/** A reference to the previous node in the list*/
	private DLLNode<T> previous;
	
	
	
	/**
	 * Constructs a node
	 * @param d The data to put into the new node
	 */
	public DLLNode(T d) {
		setData(d);
		next = null;
		previous = null;
		
	}
	
	/** 
	 * Mutator method for the data held within this node
	 * @param b The book to contain in this node
	 */
	public void setData(T b) {
		data = b;
	}
	
	/**
	 * Mutator method for the next node data member
	 * @param n The node to set as the next node
	 */
	public void setNext(DLLNode<T> n) {
		next = n;
	}
	
	/**
	 * Mutator method for the previous node data member
	 * @param p The node to set as the previous node.
	 */
	public void setPrevious(DLLNode<T> p){
		previous = p;
	}
	
	/**
	 * Returns the data contained in this node
	 * @return The data contained in this node
	 */
	public T getData(){
		return data;
	}
	
	/**
	 * Returns a reference to the next node in the list
	 * @return A reference to the next node in the list
	 */
	public DLLNode<T> getNext(){
		return next;
	}
	
	/**
	 * Returns a reference to the previous node in the list.
	 * @return A reference to the previous node in the list
	 */
	public DLLNode<T> getPrevious() {
		return previous;
	}
	
	public String toString() {
		return data.toString();
	}
	
}
