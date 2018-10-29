package com.nina.ds;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class HistogramMaxArea2 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
	
		String[] inData = scanner.nextLine().split(" ");
		
		Stack<Integer> minStack = new Stack<Integer>();
		
		int maxArea = 0;
		ArrayList<Integer> valueArray = new ArrayList<Integer>();
		
		ArrayList<Stack<Integer>> stackArray = new ArrayList<Stack<Integer>>();
		
		for(int i=0; i<inData.length; i++){
			int data = Integer.valueOf(inData[i]);
			valueArray.add(data);
			
		}
		
		for(int i=0; i<valueArray.size(); i++){
			int data = valueArray.get(i);
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(data);
			
			for(int j=i-1; j>=0; j--){
				if(valueArray.get(j)>data){
					stack.push(data);
				}else
					break;
			}	
			
			for(int j=i+1; j<valueArray.size(); j++){
				if(valueArray.get(j)> data)
					stack.push(valueArray.get(j));
				else
					break;
			}
	 
			int area = stack.size()*data;
			if(maxArea<area)
				maxArea = area;
		}
		System.out.println(maxArea);
		
		scanner.close();
		
	}
	
	
}
