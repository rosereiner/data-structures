package project4;
/**
 * 
 * @author Rose Reiner
 *
 */


	public class PQV implements Comparable<PQV> {
	    private int index;
	    private int priority;

	    /**
	    * DO NOT MODIFY THIS METHOD
	    *
	    * Constructor.
	    *
	    * @param n The name.
	    * @param p The priority.
	    */
	    public PQV(int i, int p) {
	        index = i;
	        priority = p;
	    }

	    /**
	    * DO NOT MODIFY THIS METHOD
	    *
	    * Accessor for name.
	    *
	    * @return The name.
	    */
	    public int getIndex() {
	        return index;
	    }

	    /**
	    * DO NOT MODIFY THIS METHOD
	    *
	    * Accessor for priority.
	    *
	    * @return The priority.
	    */
	    public int getPriority() {
	        return priority;
	    }

	    /**
	    * Lab 10: STUDENT MUST COMPLETE THIS METHOD
	    *
	    * Implement compareTo so that when this class is used in a priority queue,
	    * the lowest value of priority will be the first removed from the queue.
	    */
	    public int compareTo(PQV other) {
	        // add code to complete this method.
	    	if(this.priority < other.priority){
	    		return -1;
	    	} else {
	    		return 1;
	    	}


	    }

	}