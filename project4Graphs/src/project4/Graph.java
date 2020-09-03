package project4;
/**
* Represents a graph.
*
* @author Christine Reilly and Rose Reiner
*/

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Graph {

	/** Array of Vertex objects, one vertex for each node in the graph */
	private Vertex[] v;

	/** */
	private int[][] adjacencyMatrix;

	/**
	 * Creates a graph with room for the specified number of vertices.
	 *
	 * @param numVs
	 *            The number of vertices this graph will have
	 */
	public Graph(int numVs) {

		// Create the array of Vertex objects
		v = new Vertex[numVs];

		//
		adjacencyMatrix = new int[numVs][numVs];

		// initialize each Vertex and list
		for (int i = 0; i < numVs; i++) {
			// Initialize the vertex
			v[i] = new Vertex("empty");

		}
	}

	/**
	 * Adds a vertex to the graph.
	 *
	 * @param vNum
	 *            The number to associate with this vertex in the graph.
	 * @param vName
	 *            The name to associate with this vertex.
	 * @exception IllegalArgumentException
	 *                if vNum is not a valid vertex number.
	 */
	public void addVertex(int vNum, String vName) {
		if (vNum < 0 || vNum >= v.length) {
			throw new IllegalArgumentException("vNum is not a valid vertex: " + vNum);
		}

		v[vNum].setName(vName);
	}

	/**
	 * Adds an undirected, unweighted edge between the two vertices.
	 *
	 * @param v1
	 *            Vertex number of one endpoints of the edge.
	 * @param v2
	 *            Vertex number of the other endpoint of the edge.
	 * @exception IllegalArgumentException
	 *                if either parameter is not a valid vertex number.
	 */
	public void addEdge(int v1, int v2) {
		if (v1 < 0 || v1 >= v.length) {
			throw new IllegalArgumentException("v1 is not a valid vertex: " + v1);
		}
		if (v2 < 0 || v2 >= v.length) {
			throw new IllegalArgumentException("v2 is not a valid vertex: " + v2);
		}

		adjacencyMatrix[v1][v2] = 1;
		adjacencyMatrix[v2][v1] = 1;

	}

	/**
	 * Adds a directed, unweighted edge from vertex v1 to vertex v2.
	 *
	 * @param v1
	 *            Vertex number of the starting vertex for the edge.
	 * @param v2
	 *            Vertex number of the destination vertex for the edge.
	 * @exception IllegalArgumentException
	 *                if either parameter is not a valid vertex number.
	 */
	public void addDirectedEdge(int v1, int v2) {
		if (v1 < 0 || v1 >= v.length) {
			throw new IllegalArgumentException("v1 is not a valid vertex: " + v1);
		}
		if (v2 < 0 || v2 >= v.length) {
			throw new IllegalArgumentException("v2 is not a valid vertex: " + v2);
		}

		//
		adjacencyMatrix[v1][v2] = 1;

	}

	/**
	 * Adds an undirected, weighted edge between the two vertices.
	 *
	 * @param v1
	 *            Vertex number of one endpoints of the edge.
	 * @param v2
	 *            Vertex number of the other endpoint of the edge.
	 * @param w
	 *            Weight of the edge. Must be greater than zero.
	 * @exception IllegalArgumentException
	 *                if either vertex is not a valid vertex number, or if the
	 *                weight is not greater than zero.
	 */
	public void addEdgeWithWeight(int v1, int v2, int w) {
		if (v1 < 0 || v1 >= v.length) {
			throw new IllegalArgumentException("v1 is not a valid vertex: " + v1);
		}
		if (v2 < 0 || v2 >= v.length) {
			throw new IllegalArgumentException("v2 is not a valid vertex: " + v2);
		}
		if (w <= 0) {
			throw new IllegalArgumentException("w is not greater than zero" + w);
		}

		adjacencyMatrix[v1][v2] = w;
		adjacencyMatrix[v2][v1] = w;

	}

	/**
	 * Adds a directed, weighted edge from vertex v1 to vertex v2.
	 *
	 * @param v1
	 *            Vertex number of the starting vertex for the edge.
	 * @param v2
	 *            Vertex number of the destination vertex for the edge.
	 * @param w
	 *            Weight of the edge. Must be greater than zero.
	 * @exception IllegalArgumentException
	 *                if either vertex is not a valid vertex number, or if the
	 *                weight is not greater than zero.
	 */
	public void addDirectedEdgeWithWeight(int v1, int v2, int w) {
		if (v1 < 0 || v1 >= v.length) {
			throw new IllegalArgumentException("v1 is not a valid vertex: " + v1);
		}
		if (v2 < 0 || v2 >= v.length) {
			throw new IllegalArgumentException("v2 is not a valid vertex: " + v2);
		}
		if (w <= 0) {
			throw new IllegalArgumentException("w is not greater than zero" + w);
		}

		adjacencyMatrix[v1][v2] = w;
	}

	/**
	 * Sets every vertex in the graph to the unvisited state.
	 */
	private void makeAllUnvisited() {
		for (int i = 0; i < v.length; i++) {
			v[i].setUnvisited();
		}
	}

	/**
	 * Returns a string representation of the graph vertices traversed in bredth
	 * first order from the specified starting vertex.
	 *
	 * @param start
	 *            The starting vertex
	 * @return A string representation of the graph vertices traversed in bredth
	 *         first order; For each node includes node name and vertex number.
	 * @exception IllegalArgumentException
	 *                if start is not a valid vertex number.
	 */
	public String bfs(int start) {
		if (start < 0 || start >= v.length) {
			throw new IllegalArgumentException("start is not a valid vertex: " + start);
		}

		String output = "";

		// Use a queue to store the nodes that are waiting to be visited.
		// Queue is an interface. We can declare a variable of type Queue
		// then create a LinkedList object for that Queue.
		Queue<Integer> q = new LinkedList<Integer>();

		// Initialize all vertices to unvisited
		makeAllUnvisited();

		// Enqueue the start vertex
		q.add(start);
		v[start].setWaiting();

		while (!q.isEmpty()) {

			// Dequeue the vertex at the front of the queue and add its
			// information
			// to the output string. Mark that vertex as visited.
			int dqv = q.remove();
			v[dqv].setVisited();
			output += "[" + v[dqv].getName() + ", " + dqv + "]; ";

			// Enqueue all adjacent, unvisited vertices to dqv.
			// Loop through dqv's edgeList. Add unvisited vertices to the
			// queue and set those vertices to the waiting state.
			int[] edges = adjacencyMatrix[dqv];
			for (int i = 0; i < edges.length; i++) {
				if (v[i].isUnvisited() && adjacencyMatrix[dqv][i] != 0) {
					q.add(i);
					v[i].setWaiting();
				}
			}
		}
		return output;
	} // end of bfs method

	/**
	 * Returns a string representation of the graph vertices traversed in depth
	 * first order from the specified starting vertex.
	 *
	 * @param start
	 *            The starting vertex
	 * @return A string representation of the graph vertices traversed in depth
	 *         first order; For each node includes node name and vertex number.
	 * @exception IllegalArgumentException
	 *                if start is not a valid vertex number.
	 */
	public String dfs(int start) {
		if (start < 0 || start >= v.length) {
			throw new IllegalArgumentException("start is not a valid vertex: " + start);
		}

		String output = "";

		// Use a stack to keep track of vertices that still need to be checked
		// for the depth traversal
		LinkedList<Integer> stack = new LinkedList<Integer>();

		// Initialize all vertices to unvisited
		makeAllUnvisited();

		// Add the starting vertex to the stack
		stack.push(start);

		// Visit the starting vertex
		output += "[" + v[start].getName() + ", " + start + "]; ";
		v[start].setVisited();

		// Keep visiting nodes in depth first order
		while (!stack.isEmpty()) {
			// Peek at the top of the stack
			int peeked = stack.peek();

			// Get the edgeList for the vertex at the top of the stack
			int[] edges = adjacencyMatrix[peeked];

			boolean found = false; // if an unvisited adjacent vertex is found
			int i = 0; // counter

			// look for an adjacent vertex that has not been visited
			while (i < edges.length && !found) {

				if (v[i].isUnvisited() && adjacencyMatrix[peeked][i] != 0) {
					// found an unvisited adjacent vertex
					found = true;
					stack.push(i);

					// visit the found vertex
					output += "[" + v[i].getName() + ", " + i + "]; ";
					v[i].setVisited();
				}
				i++;
			}

			if (!found) {
				// the current vertex has no unvisited adjacent vertices
				// pop the current vertex off the stack
				stack.pop();
			}
		}

		return output;
	} // end of dfs method

	/**
	 * Returns a string that contains information about the shortest path from the 
	 * given node to every node in the graph, including the path from the given node to itself.
	 */

	public String dijkstras(int start) {
		makeAllUnvisited();

		int pathLen[] = new int[v.length];
		ArrayList<ArrayList<Integer>> path = new ArrayList<>();

		for (int i = 0; i < v.length; i++) {
			pathLen[i] = Integer.MAX_VALUE;
			path.add(i, new ArrayList<>());
		}
		pathLen[start] = 0;

		PriorityQueue<PQV> pq = new PriorityQueue<PQV>();

		pq.add(new PQV(start, 0));

		while (!pq.isEmpty()) {
			int vIndex = pq.remove().getIndex();
			v[vIndex].setVisited();
			for (int i = 0; i < v.length; i++) {
				if (v[i].isUnvisited() && adjacencyMatrix[vIndex][i] != 0) {
					if (pathLen[i] > pathLen[vIndex] + adjacencyMatrix[vIndex][i]) {
						pathLen[i] = pathLen[vIndex] + adjacencyMatrix[vIndex][i];

						ArrayList<Integer> newList = new ArrayList<Integer>();
						for (int x = 0; x < path.get(vIndex).size(); x++) {
							newList.add(x, new Integer(path.get(vIndex).get(x).toString()));
						}
						newList.add(i);
						path.set(i, newList);
						pq.add(new PQV(i, pathLen[i]));
					}

				}
			}

		}

		return printPathLength(pathLen, start, path);
	}

	/**
	 * Returns a string that contains information about the shortest path from the
	 * given node to every node in the graph, including the path from the given node to itself.
	 */
	public String shortestPath(int start) {
		makeAllUnvisited();

		int pathLen[] = new int[v.length];
		ArrayList<ArrayList<Integer>> path = new ArrayList<>();

		for (int i = 0; i < v.length; i++) {
			pathLen[i] = Integer.MAX_VALUE;
			path.add(i, new ArrayList<>());
		}
		pathLen[start] = 0;

		PriorityQueue<PQV> pq = new PriorityQueue<PQV>();

		pq.add(new PQV(start, 0));

		while (!pq.isEmpty()) {
			int vIndex = pq.remove().getIndex();
			v[vIndex].setVisited();
			for (int i = 0; i < v.length; i++) {
				if (v[i].isUnvisited() && adjacencyMatrix[vIndex][i] != 0) {
					if (pathLen[i] > pathLen[vIndex] + 1) {
						pathLen[i] = pathLen[vIndex] + 1;
						pq.add(new PQV(i, pathLen[i]));

						// Create a new ArrayList
						ArrayList<Integer> newList = new ArrayList<Integer>();

						for (int x = 0; x < path.get(vIndex).size(); x++) {

							ArrayList<Integer> charlie = path.get(vIndex);
							Integer charlie2 = charlie.get(x);
							String charlie3 = charlie2.toString();

							newList.add(x, new Integer(charlie3));

						}
						newList.add(i);
						path.set(i, newList);
						pq.add(new PQV(i, pathLen[i]));

					}

				}
			}

		}
		return printPathLength2(pathLen, start, path);

		// return "";

	}

	/**
	 * Method that will be called on the dijkstras method to print it's path length and path.
	 */
	public String printPathLength(int p[], int start, ArrayList<ArrayList<Integer>> path) {
		String output = "";

		for (int i = 0; i < p.length; i++) {
			output += "Minimum weight path from " + v[start].getName() + " " + start + " to " + v[i].getName() + " " + i
					+ " is " + p[i] + ", path: from " + v[start].getName() + " " + start;

			for (int x = 0; x < path.get(i).size(); x++) {
				output += " to " + v[path.get(i).get(x)].getName() + " " + path.get(i).get(x);

			}
			if (i == 0) {
				output += " to " + v[start].getName() + " " + start;
			}
			output += "\n";

		}

		return output;
	}

	/**
	 * Method that will be called on the shortestPath to print it's path length and path.
	 */
	public String printPathLength2(int p[], int start, ArrayList<ArrayList<Integer>> path) {
		String output = "";
		for (int i = 0; i < p.length; i++) {
			output += v[start].getName() + " " + start + " to " + v[i].getName() + " " + i + " is " + p[i]
					+ ", path: from " + v[start].getName() + " " + start;

			for (int x = 0; x < path.get(i).size(); x++) {
				output += " to " + v[path.get(i).get(x)].getName() + " " + path.get(i).get(x);
			}
			if (i == 0) {
				output += " to " + v[start].getName() + " " + start;
			}
			output += "\n";
		}
		return output;

	}

}
