package sortingAlghoritms;

import java.util.Arrays;

public class BubbleSortEnhaced {

	// MODIFIED BUBBLE SORT INCLUDES BREAK
	public static int[] bubbleSortWithBreak(int[] arrayToSort, SorterObject results) {

		int[] arr = Arrays.copyOf(arrayToSort, arrayToSort.length);

		long startTime = System.currentTimeMillis();

		// Temp variable used for swapinng
		int temp = 0;
		// Outer loop
		for (int i = 0; i < arr.length - 1; i++) { // Variable to hold swaps
			int swaps = 0;
			// inner loop
			for (int j = 0; j < arr.length - 1; j++) {
				// Increase number of comparisons
				results.numberOfComparisons++;
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					// Increase if swap occured
					swaps++;
	                results.numberOfSwaps++;

				}
			}
			if (swaps == 0)
				break;
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
        // Save time elapsed in global results object
        results.time = elapsedTime;
		return arr;
	}

}
