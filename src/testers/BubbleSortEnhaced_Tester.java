package testers;
import java.util.Arrays;

import sortingAlghoritms.*;
public class BubbleSortEnhaced_Tester {

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
		System.out.println(Arrays.toString(BubbleSortEnhaced.bubbleSortWithBreak(numbers, results)));
		// Display details 
		System.out.println("Time taken: " + results.time +"ms");
		System.out.println("Swaps: " + results.numberOfSwaps);
		System.out.println("Comparisons: " + results.numberOfComparisons);		
		results.reset();
		
		
		// *************
		// Print and sort array
		System.out.println(Arrays.toString(BubbleSortEnhaced.bubbleSortWithBreak(ascendingArray, results)));
		// Display details 
		System.out.println("Time taken: " + results.time +"ms");
		System.out.println("Swaps: " + results.numberOfSwaps);
		System.out.println("Comparisons: " + results.numberOfComparisons);	
		results.reset();

		// *************
		// Print and sort array
		System.out.println(Arrays.toString(BubbleSortEnhaced.bubbleSortWithBreak(descendingArray, results)));
		// Display details 
		System.out.println("Time taken: " + results.time +"ms");
		System.out.println("Swaps: " + results.numberOfSwaps);
		System.out.println("Comparisons: " + results.numberOfComparisons);
		results.reset();

		

		
		
	}

}
