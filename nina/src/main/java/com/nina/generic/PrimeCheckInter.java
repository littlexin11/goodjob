package com.nina.generic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.*;
import java.util.HashSet;
import java.util.Set;
import static java.lang.System.in;

class Prime {
    void checkPrime(Integer... inputs){
        for(int i=0; i<inputs.length; i++){
            System.out.print(isPrime(inputs[i])?inputs[i]+" ":"");
        }
        System.out.println("");
    }
    
    boolean isPrime(Integer input){
    	if(input <=1)
    		return false;
    	
    	if(input ==2)
    		return true;
    	
    	if(input%2==0)
    		return false;
    	
        for(int i=3; i*i<=input; i++) {
        	if(input%i == 0) 
        		return false;
        }
        return true;
    }
}

public class PrimeCheckInter {
	
	public static void main(String[] args) {
		try 
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			int n1=Integer.parseInt(br.readLine());
			int n2=Integer.parseInt(br.readLine());
			int n3=Integer.parseInt(br.readLine());
			int n4=Integer.parseInt(br.readLine());
			int n5=Integer.parseInt(br.readLine());
			Prime ob=new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1,n2);
			ob.checkPrime(n1,n2,n3);
			ob.checkPrime(n1,n2,n3,n4,n5);	
			Method[] methods=Prime.class.getDeclaredMethods();
			Set<String> set=new HashSet<>();
			boolean overload=false;
			for(int i=0;i<methods.length;i++)
			{
				if(set.contains(methods[i].getName()))
				{
					overload=true;
					break;
				}
				set.add(methods[i].getName());
				
			}
			if(overload)
			{
				throw new Exception("Overloading not allowed");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}


}
