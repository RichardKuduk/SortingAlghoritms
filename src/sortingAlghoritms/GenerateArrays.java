package sortingAlghoritms;

import java.util.Random;

public  class GenerateArrays {

	
	// Method to generate array 1 - 10000
    public static void populateAscendingArray(int[] array)
    {
        
        for(int i = 0 ; i < array.length ; i++)
        {
            array[i] =  i;
        }
       
    }
    
    //Method to generate array from 1000 to 1 
      public static void populateDescendingArray(int[] array)
    {
        
        
        for(int i = 0 ; i < array.length ; i++)
        {
            array[i] = array.length-1-i;
        }
        
    }
    // Method to generate random number
    public static void generateRandomNumbers(int[] array)
    {   
        Random rand = new Random();
        for (int i = 0; i < array.length; i++)
        {
            int n = rand.nextInt(100);
            array[i] = n;
        }
    }
	
	
}
