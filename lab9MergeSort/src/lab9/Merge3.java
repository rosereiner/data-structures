package lab9;

/**
 * CS206 Lab 9: 3-way merge
 *
 * Student's Name: Rose Reiner and Mara Greene
 */

public class Merge3 {
	/**
	 * Lab 9: STUDENT MUST COMPLETE THIS METHOD
	 *
	 * Merges three sorted sublist into a single sorted list. This method could
	 * be used as the merge step in a 3-way merge sort. When this method
	 * returns, list is in sorted order from index start to index end
	 * (inclusive).
	 *
	 * @param list
	 *            Array that contains the sublists
	 * @param start
	 *            Beginning index of sub-list A
	 * @param mid1
	 *            End index of sub-list A; sub-list B begins at index mid1 + 1
	 * @param mid2
	 *            End index of sub-list B; sub-list C begins at index mid2 + 1
	 * @param end
	 *            End index of sub-list C
	 */
	public static void merge3(int[] list, int start, int mid1, int mid2, int end) {
		// Lab 9: complete this method

		int[] tempArray = new int[end - start + 1]; // temporary array for the
													// sorted values
		int i = 0; // index into tempArray
		int li = start;
		int mi = mid1 + 1;
		int ri = mid2 + 1;

		// Loop through the array
		while (li <= mid1 && mi <= mid2 && ri <= end) {
			if (list[li] <= list[mi] && list[li] <= list[ri]) {
				// left list has the smallest value
				tempArray[i] = list[li]; // add value in left list into the new
											// array
				li++; // move to the next place in the list
			} else if (list[mi] <= list[li] && list[mi] <= list[ri]) {
				// middle list has the smallest value
				tempArray[i] = list[mi]; // add middle value into the new array
				mi++;

			} else {
				// the right list has the smallest value
				tempArray[i] = list[ri];
				ri++;
			}
			i++; // increment tempArray index
		}

		// Finished some lists before the others
		
		//check if the left list is at the middle list
		if(li == mid1+1){
			while(mi <= mid2 && ri <= end){
				if(list[mi] <= list[ri]){
					tempArray[i] = list[mi];
					mi++;
				} else{
					tempArray[i] = list[ri];
					ri++;
				}
				i++;
			}
		} else if(mi == mid2+1){ //Check if middle list is at the third list
			while(li <= mid1 && ri <= end){
				if(list[li] <= list[ri]){
					tempArray[i] = list[li];
					li++;
				} else {
					tempArray[i] = list[ri];
					ri++;
				}
				i++;
			}
		} else if(ri == end + 1){ //Check if the last list is out of bounds
			while(li <= mid1 && mi <= mid2){
				if(list[li] <= list[mi]){
					tempArray[i] = list[li];
					li++;
				} else {
					tempArray[i] = list[mi];
					mi++;
				}
				i++;
			}
		}
		
		//If two of the lists are empty
		if(li == mid1+1 && mi == mid2 + 1){ //if left and middle list is empty
			while(ri <= end){
				tempArray[i] = list[ri];
				ri++;
				i++;
			}
		}else if(mi == mid2 + 1 && ri == end + 1){ //if middle and right list is empty
			while(li <= mid1){
				tempArray[i] = list[li];
				li++;
				i++;
			}
		}else if(li == mid1+1 && ri == end + 1){ //if left and last list are empty
			while(mi <= mid2){
				tempArray[i] = list[mi];
				mi++;
				i++;
			}
		}
		//Move elements in the tempArray to the list array
		int y = start;
		for(int x=0; x < tempArray.length; x++){
			list[y] = tempArray[x];
			y++;
		}

	}

	/**
	 * Prints the elements of an array, one element per line.
	 *
	 * @param list
	 *            The array to print
	 */
	public static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}