package project2;

public class Project2_Test2 {

	public static void main(String[] args){
		
		// Test the Node class using String objects
		DLLNode<String> ns1 = new DLLNode<String>("Hello");
		DLLNode<String> ns2 = new DLLNode<String>("Whats up");
		DLLNode<String> ns3 = new DLLNode<String>("Bye");
	
		//Link the nodes in order 
		ns1.setNext(ns2);
		ns2.setNext(ns3);
		System.out.println("middle string: " + ns1.getNext().getData());
		System.out.println("last string: " + ns1.getNext().getNext().getData());
	
	
		 // Test the Node class using Book objects

	}

}
