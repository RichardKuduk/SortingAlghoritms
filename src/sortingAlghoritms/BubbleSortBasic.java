package sortingAlghoritms;
import java.util.Arrays;

public class BubbleSortBasic {

	
	 // Basic Bubble Sort
    public static int[] bubbleSortBasic(int [] arrayToSort , SorterObject results)
    {
    	// Create a copy of array than was send
        int [] arr = Arrays.copyOf(arrayToSort,arrayToSort.length);
        // Start the timer
        long startTime = System.currentTimeMillis(); 
        // Variable used for swaping elements
        int temp = 0;  
        // Outer loop
        for(int i=0; i < arr.length-1; i++)
        {  
            // inner loop
            for(int j=0; j < arr.length-1; j++)
            {  
            	// Increase number of comparisons
            	results.numberOfComparisons++;
                if(arr[j] > arr[j+1])
                {  
	                temp = arr[j];  
	                arr[j] = arr[j+1];  
	                arr[j+1] = temp; 
	                // Increase number of swaps
	                results.numberOfSwaps++;
                }
            }
        }  
        // Stop the timer
        long stopTime = System.currentTimeMillis();
        // Calculate time 
        long elapsedTime = stopTime - startTime;
        // Save time elapsed in global results object
        results.time = elapsedTime;
        // Return sorted array
        return arr;
        
    }	
	
	
}
