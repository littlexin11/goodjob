package com.nina.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class SortInter {

	/*
	 * Given a sorted array , 
	 * return the sorted array containing squares of elements
	 */
	public static void main(String[] args) {
		
		Integer[] inDataArray = {-5,-3,-1,0,2,3};
		
		List<Integer> list = Arrays.asList(inDataArray);
		
		
		 list.stream().map( i -> i*i).sorted().collect(Collectors.toList()).forEach(i -> System.out.println(i));

		
	}
	
}
