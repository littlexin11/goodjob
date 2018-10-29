package com.nina.string;

import java.util.ArrayList;

public class Combination {
	  /* arr[]  ---> Input Array 
    data[] ---> Temporary array to store current combination 
    start & end ---> Staring and Ending indexes in arr[] 
    index  ---> Current index in data[] 
    r ---> Size of a combination to be printed */
    static void combinationUtil(String[] arr, String[] data, int start, 
                                int end, int index, int r) 
    { 
        // Current combination is ready to be printed, print it 
        if (index == r) 
        { 
            for (int j=0; j<r; j++) 
                System.out.print(data[j]+" "); 
            System.out.println(""); 
            return; 
        } 
  
        // replace index with all possible elements. The condition 
        // "end-i+1 >= r-index" makes sure that including one element 
        // at index will make a combination with remaining elements 
        // at remaining positions 
        for (int i=start; i<=end && end-i+1 >= r-index; i++) 
        { 
            data[index] = arr[i]; 
            System.out.println("***"+printData(data));
            combinationUtil(arr, data, i+1, end, index+1, r); 
        } 
    } 
  
    // The main function that prints all combinations of size r 
    // in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(String[] arr, int n, int r) 
    { 
        // A temporary array to store all combination one by one 
    	String[] data =new String[r]; 
  
        // Print all combination using temprary array 'data[]' 
        combinationUtil(arr, data, 0, n-1, 0, r); 
    } 
  
    /*Driver function to check for above function*/
    public static void main (String[] args) { 
        String[] arr = {"A", "B", "C"}; 
        //int r = 3; 
        int n = arr.length; 
        for(int i=1; i<=n; i++){
        printCombination(arr, n, i); 
        }
    } 

    public static String printData(String[] data){
    	String print="";
    	for (int j=0; j<data.length; j++) 
    		print+=data[j]+" "; 
    	return print;
    }
}
