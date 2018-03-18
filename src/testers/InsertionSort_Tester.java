package testers;
import java.util.Arrays;

import sortingAlghoritms.*;
public class InsertionSort_Tester {
	// Richard Kuduk - L00120064
	// Lyit - Assigment for Alghoritms and Data Structures
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create Object to store results
		SorterObject results = new SorterObject();
		// Create an array
		int n = 10; // Number of elements 
		// Create and fill with random
		int [] numbers = new int[n];
		GenerateArrays.generateRandomNumbers(numbers);
		// Create and fill ascending
		int [] ascendingArray  = new int[n];
		GenerateArrays.populateAscendingArray(ascendingArray);
		// Create and fill descending
		int [] descendingArray = new int[n];
		GenerateArrays.populateDescendingArray(descendingArray);

		
		// Print original array
		System.out.println(Arrays.toString(numbers));
		System.out.println("**************************************");

		// Reset variables to zero
		results.reset();
		// Print and sort array
		System.out.println(Arrays.toString(InsertionSort.doInsertionSort(numbers, results)));
		// Display details 
		System.out.println("Time taken: " + results.time +"ms");
		System.out.println("Swaps: " + results.numberOfSwaps);
		System.out.println("Comparisons: " + results.numberOfComparisons);		
		results.reset();
		
		
		// *************
		// Print original array
				System.out.println(Arrays.toString(ascendingArray));
				System.out.println("**************************************");
		// Print and sort array
		System.out.println(Arrays.toString(InsertionSort.doInsertionSort(ascendingArray, results)));
		// Display details 
		System.out.println("Time taken: " + results.time +"ms");
		System.out.println("Swaps: " + results.numberOfSwaps);
		System.out.println("Comparisons: " + results.numberOfComparisons);	
		results.reset();

		// *************
		// Print original array
		System.out.println(Arrays.toString(descendingArray));
		System.out.println("**************************************");
		// Print and sort array
		System.out.println(Arrays.toString(InsertionSort.doInsertionSort(descendingArray, results)));
		// Display details 
		System.out.println("Time taken: " + results.time +"ms");
		System.out.println("Swaps: " + results.numberOfSwaps);
		System.out.println("Comparisons: " + results.numberOfComparisons);
		results.reset();
		

		

		
		
	}

}
