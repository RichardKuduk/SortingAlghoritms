package sortingAlghoritms;

import java.util.Arrays;

public class SelectionSort {
	// Richard Kuduk - L00120064
	// Lyit - Assigment for Alghoritms and Data Structures

	public static int[] doSelectionSort(int[] arrayToSort, SorterObject results) {
		
		   int [] arr = Arrays.copyOf(arrayToSort,arrayToSort.length);
	        
	        long startTime = System.currentTimeMillis(); 
	        
	        for(int i = 0; i < arr.length - 1 ; i++)
	        {
	            int minimum = i;
	            for(int j = i+1; j < arr.length ; j++)
	            {
		            results.numberOfComparisons++;
	                if(arr[j] < arr[minimum])
	                    minimum = j;
	            }
	            int temp = arr[i];
	            arr[i] = arr[minimum];
	            arr[minimum] = temp;   
	            results.numberOfSwaps++;
	            //System.out.println(Arrays.toString(arr));
	        }
	        
	        long stopTime = System.currentTimeMillis();
	        long elapsedTime = stopTime - startTime;
	        results.time = elapsedTime;
	        return arr;
	}
}
