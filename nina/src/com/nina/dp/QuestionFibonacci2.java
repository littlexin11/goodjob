package com.nina.dp;


import java.util.Scanner;

public class QuestionFibonacci2 {

	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System. in); 
		long n = scanner. nextLong();
		
		long n1 = 0;
		long n2 = 1;
		
		if(n==1) {
			System.out.println(n1);
			scanner.close();
			return;
		}
		
		
		
		System.out.println(fibonacci(n));
		
		scanner.close();
	}
	
	public static long fibonacci(long n) {
		if(n==1)
			return 0;
		
		if(n==2)
			return 1;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}
}
