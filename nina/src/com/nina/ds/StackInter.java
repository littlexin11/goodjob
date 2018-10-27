package com.nina.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StackInter {

	/*
	 * 
	 * A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.

Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})" 

Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.

Given a string, determine if it is balanced or not.

Input Format

There will be multiple lines in the input file, each having a single non-empty string. You should read input till end-of-file.

The part of the code that handles input operation is already provided in the editor.

Output Format

For each case, print 'true' if the string is balanced, 'false' otherwise.
	 * sample input
	 * 
4
{}()
({()})
{}(
[]

	 *sample output
true
true
false
true
	 */
	
	public static void main(String[] arg) {
		Scanner scaner = new Scanner(System.in);
		List<String> inStringList = new ArrayList<String>();
		
		int n=scaner.nextInt();
		scaner.nextLine();
		while (n > 0) {
			
			String line=scaner.nextLine();
			System.out.println(line);
			inStringList.add(line);
			n--;
		}
		
		scaner.close();
		
		for(String input: inStringList) {
			Stack stack = new Stack();
			
			char[] chars = input.toCharArray();
			boolean flag = true;
			
			for(char c: chars) {
				if(flag) {
				switch(c) {
					case '{':
						stack.push(c);
						break;
					case '(':
						stack.push(c);
						break;
					case '[':
						stack.push(c);
						break;
					case '}':
						
						if('{' != (char)stack.pop()) 
							flag = false;
						break;
					case ')':
						if('(' != (char)stack.pop()) 
							flag = false;
						break;
					case ']':
						if('[' != (char)stack.pop()) 
							flag = false;
						break;
						
					default:
						//not do anything
						break;
						
				}
				}
				
				
			}
			if(stack.size()==0)
				System.out.println("true");
			else
				System.out.println("false");
			
		}
		
		
	}
	
	
}
