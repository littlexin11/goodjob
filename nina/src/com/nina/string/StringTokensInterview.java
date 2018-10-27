package com.nina.string;

import java.io.*;
import java.util.*;

public class StringTokensInterview {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        
        String[] tokenStrings =s.split("[ !,?._'@]");
         
        String[] newTokenStrings = new String[tokenStrings.length];
        int j=0;
        for (int i=0; i<tokenStrings.length; i++){
        	System.out.println(tokenStrings[i]);
        	if(tokenStrings[i]!=null && !"".equals(tokenStrings[i])){
                newTokenStrings[j] = tokenStrings[i];
                j++;
            }
        }
        System.out.println(j);
        for (int i=0; i<j; i++){
            System.out.println(newTokenStrings[i]);
            
        }
        scan.close();
    }
}
