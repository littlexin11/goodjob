package com.nina.string;

import java.util.Scanner;

public class CheckIsomorphic {
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
		    //System.out.println(s1);
		    //System.out.println(s2);
		    checkIsomorphic(s1, s2);
		}
		scanner.close();
	}
	
	public static void checkIsomorphic(String s1, String s2) {
	    boolean flag=true;
	    while(s1.length()>0 && flag){
	    	//System.out.println("----while");
	    	if(checkSpaceMatch(s1,s2)){
	    		s1 = s1.replaceAll(" ", "");
	    		s2 = s2.replaceAll(" ", "");
	    		//System.out.println("--"+s1);
			    //System.out.println("--"+s2);
			    if(s1.length()>0 && s2.length()>0){
			    	s1=s1.replaceAll(s1.substring(0, 1), " ");
			    	s2=s2.replaceAll(s2.substring(0, 1), " ");
			    	//System.out.println("----"+s1);
			    	//System.out.println("----"+s2);
			    }
	    		
	    	}else{
	    		flag=false;
	    	}
	    }
	    
	    System.out.println(flag?1:0);
	}
	
	public static boolean checkSpaceMatch(String s1, String s2) {
		if(s1.length()!=s2.length())
			return false;
		
		int startIndex=0;
		while (startIndex < s1.length()-1){
			//System.out.println("----while2 startIndex="+startIndex);
			if(s1.indexOf(" ", startIndex)==-1 && s2.indexOf(" ", startIndex)==-1){
				return true;
			}
			else if(s1.indexOf(" ", startIndex)==s2.indexOf(" ", startIndex)){
				startIndex = s1.indexOf(" ", startIndex)+1;
			}else{
				return false;
			}
		}
		return true;
	}

	
}
