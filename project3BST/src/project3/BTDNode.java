package project3;
import java.util.LinkedList;

/**
 * 
 * @author Rose Reiner
 *
 * @param <T> any type of object
 */


public class BTDNode<T> {

	/**
	 * A class that constructs a BTNode
	 * 
	 * @param <T>
	 *            refers to any object
	 */

	/** The data in this node */
	private LinkedList<T> key;

	/** Reference to the left child node */
	private BTDNode<T> left;

	/** Reference to the right child node */
	private BTDNode<T> right;

	/** Reference to the parent of this node */
	private BTDNode<T> parent;

	/**
	 * Initialize the data and set children nodes to null
	 * 
	 * @param d
	 *            The data to put into this node
	 */
	public BTDNode(T d) {
		setKey(d);
		left = null;
		right = null;
		parent = null;
	}

	/**
	 * Accessor method for the data
	 * 
	 * @return The data contained by this node
	 */
	public T getKey() {
		return key.getFirst();
	}
	/**
	 * 
	 */
	public LinkedList<T> getKeyList() {
		return key;
	}

	/**
	 * Accessor method for the left child node.
	 * 
	 * @return A reference to the left child node
	 */
	public BTDNode<T> getLeft() {
		return left;
	}

	/**
	 * Accessor method for the right child node
	 * 
	 * @return A reference to the right child node
	 */
	public BTDNode<T> getRight() {
		return right;
	}

	/**
	 * Accessor method for the parent node
	 * 
	 * @return A reference to the parent node
	 */
	public BTDNode<T> getParent() {
		return parent;
	}

	/**
	 * Mutator method for the data
	 * 
	 * @param d
	 *            The data to put into this node
	 */
	public void setKey(T d) {
		key = new LinkedList<T>();
		key.add(d);
	}
	
	/**
	 * Method to be able to add multiple keys
	 */
	public void addKey(T d) {
		key.add(d);
	}

	/**
	 * Mutator method for the left child node
	 * 
	 * @param l
	 *            A reference to the node to set as the left child
	 */
	public void setLeft(BTDNode<T> l) {
		left = l;
	}

	/**
	 * Mutator method for the right child node
	 * 
	 * @param r
	 *            A reference to the node to set as the right
	 */
	public void setRight(BTDNode<T> r) {
		right = r;
	}

	/**
	 * Mutator method for the parent node
	 * 
	 * @param r
	 *            A reference to the node to set as the parent of this node
	 */
	public void setParent(BTDNode<T> p) {
		parent = p;
	}

}