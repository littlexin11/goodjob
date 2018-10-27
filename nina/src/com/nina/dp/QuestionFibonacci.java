package com.nina.dp;


import java.util.Scanner;

public class QuestionFibonacci {

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
		
		
		while(n>2) {
			long n3 = nextFibonacci(n1, n2);
			n1 = n2;
			n2 = n3;
			n--;
		}
		
		System.out.println(n2);
		
		scanner.close();
	}
	
	public static long nextFibonacci(long n1, long n2) {
		return n1+n2;
	}
}
