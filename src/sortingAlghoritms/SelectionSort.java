package sortingAlghoritms;

import java.util.Arrays;

public class SelectionSort {

	public static int[] doInsertionSort(int[] arrayToSort , SorterObject results)
	{
        int [] arr = Arrays.copyOf(arrayToSort,arrayToSort.length);
        
        long startTime = System.currentTimeMillis(); 

        int temp;
        for (int i = 1; i < arr.length; i++)
        {

            for(int j = i ; j > 0 ; j--)
            {
            	results.numberOfComparisons++;
                if(arr[j] < arr[j-1])
                {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
	                results.numberOfSwaps++;

                }
            }
            
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        results.time = elapsedTime;
        return arr;
    }
}
