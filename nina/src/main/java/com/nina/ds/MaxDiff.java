package com.nina.ds;


public class MaxDiff {
	
	//arr = {2, 3, 10, 6, 4, 8, 1}
	//arr = {7, 9, 5, 6, 3, 2}
	public static int findMaxDiff(Integer[] intArr){
		Integer maxResult = null;
		Integer min = intArr[0];
		for(int i=1; i<intArr.length; i++){
			if(min > intArr[i])
				min = intArr[i];
			else{
				if(maxResult == null){
					maxResult = intArr[i] - min;
				}else if((intArr[i] - min)>maxResult ){
					maxResult = intArr[i] - min;
				}
			}
		}
		return maxResult;
	}
	
	public static void main(String[] args){
		Integer[]  intArr={2, 3, 10, 6, 4, 8, 1};
		//Integer[]  intArr={7, 9, 5, 6, 3, 2};
		
		System.out.println(findMaxDiff(intArr));
	}
	

}
