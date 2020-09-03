package project4;

/**
* Represents an edge between two vertices in a graph.
*
* @author Christine Reilly
*/
public class Edge {

    /** The destination vertex of this edge */
    private int dest;

    /** The weight of this edge */
    private int weight;

    /** Constructor initializes the data members */
    public Edge(int d, int w) {
        dest = d;
        weight = w;
    }

    /**
    * Return the value of the destination vertex
    */
    public int getDest() {
        return dest;
    }

    /**
    * Return the value of the edge weight
    */
    public int getWeight() {
        return weight;
    }


}