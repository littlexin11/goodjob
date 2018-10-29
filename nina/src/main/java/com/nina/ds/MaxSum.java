package com.nina.ds;

public class MaxSum {
		
		public static int findMaxSum(Integer[] intArr){
			Integer maxSum = intArr[0];
			Integer sum = intArr[0];
			
			for(int i=1; i<intArr.length; i++){
				if(sum < 0){
					if(intArr[i] >  sum) {
						sum = intArr[i];
					}
				}else{
					sum = sum + intArr[i];										
				}
				
				if(sum>maxSum)
					maxSum = sum;
			}
			return maxSum;
		}
		
		public static void printMaxSumFinding(Integer[] intArr){
			Integer maxSum = intArr[0];
			Integer sum = intArr[0];
			int startPos = 0;
			int endPos = 0;
			
			for(int i=1; i<intArr.length; i++){
				if(sum < 0){
					if(intArr[i] >  sum) {
						sum = intArr[i];
						startPos = i;
					}
				}else{
					sum = sum + intArr[i];										
				}
				
				if(sum>maxSum) {
					maxSum = sum;
					endPos = i;
				}
			}
			System.out.println("maxSum="+maxSum);
			System.out.println("startPos="+startPos);
			System.out.println("endPos="+endPos);
			
		}
		
		public static void main(String[] args){
			Integer[] intArr = {-2, -3, 4, -1, -2, 1, 5, -3}; 
			
			System.out.println(findMaxSum(intArr));
			
			printMaxSumFinding(intArr);
		}
		
}
