package sortingAlghoritms;

import java.util.Arrays;

public class InsertionSort {
	// Richard Kuduk - L00120064
	// Lyit - Assigment for Alghoritms and Data Structures
	public static int[] doInsertionSort(int[] arrayToSort, SorterObject results) {

		int[] arr = Arrays.copyOf(arrayToSort, arrayToSort.length);
		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i < arr.length; i++) {
			//element is the value we are moving into the sorted portion these lines
			//keep track of the current place in the unsorted portion
			int next = arr[i];
			//j represents our index into the sorted portion
			int j = i;
			
			results.numberOfComparisons++;
			////next we iterate through the sorted portion from right to left.
			//We stop once the element to the left of our current position is less 
			//than the element we are trying to insert.

			while (j > 0 && arr[j - 1] > next) {
				results.numberOfComparisons++;
				//here we shift each element we compare in the sorted array one to the right,
				//providing space to insert into when we find
				//the first element less than the element we are moving
				arr[j] = arr[j - 1];
				////next we update the counter to allow us to move left through the sorted portion
				j--;
			} // insert the element
			////finally this is where we insert the
			//element we are comparing in the sorted portion.
			arr[j] = next;
			results.numberOfSwaps++;
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		results.time = elapsedTime;
		return arr;

	}
}