package com.nina.string;

import java.util.Scanner;

public class StringPattern {

	/*
3
ABCD
(^[A-Z]+$)
abcde
(^[a-z]+$)
abcdeABCD
(^[A-Za-z]+$)
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		scanner.nextLine();
		
		while(n>0){
		String s = scanner.nextLine();
		System.out.println(s);
		String p = scanner.nextLine();
		System.out.println(p);
		System.out.println(s.matches(p));
		n--;
		}
		scanner.close();
		
	}
}
