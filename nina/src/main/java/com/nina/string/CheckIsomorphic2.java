package com.nina.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckIsomorphic2 {
	/*
	 * 
2
aab
xxy
aab
xyz
	 */
	public static void main (String[] args) {
		//code
		Scanner scanner = new Scanner(System.in);
		int numTest = scanner.nextInt();
		scanner.nextLine();
		for (int i=0; i<numTest; i++){
		    String s1=scanner.nextLine();
		    String s2=scanner.nextLine();
		    System.out.println(checkIsomorphic(s1, s2)?1:0);
		    
		}
		scanner.close();
	}
	
	public static boolean checkIsomorphic(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		Map<Character, Character> map1 = new HashMap<Character, Character>();
		
		for(int i=0; i<s1.length(); i++){
			char c1=s1.charAt(i);
			char c2=s2.charAt(i);
			
			if(map1.get(c1)==null){
				map1.put(c1,  c2);
			}else{
				if(map1.get(c1)!=c2){
					return false;
				}
			}
		}
		return true;
	    
	}

	
}
