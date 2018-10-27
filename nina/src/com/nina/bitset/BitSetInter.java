package com.nina.bitset;

import java.util.BitSet;
import java.util.Scanner;

/**
5 4
AND 1 2
SET 1 4
FLIP 2 2
OR 2 1

 */
public class BitSetInter {


	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        System.out.println(n);
        System.out.println(m);
        
        scanner.nextLine();
        
        BitSet[] ba = new BitSet[2];
        BitSet b0 = new BitSet(n);
        BitSet b1 = new BitSet(n);
        
        ba[0] = b0;
        ba[1] = b1;
        
        for (int i=0; i<n; i++){
        	b0.set(i, false);
            b1.set(i, false);
        }
        System.out.println(b0);
        System.out.println(b1);
        
        for (int i=0; i<m; i++){
            String line = scanner.nextLine();
            String[] commands = line.split(" ");
            int input1=Integer.valueOf(commands[1]);
            int input2=Integer.valueOf(commands[2]);
            
            if(commands[0].equals("AND")){
                ba[input1-1].and(ba[input2-1]);
            }else if(commands[0].equals("SET")){
                ba[input1-1].set(input2, true);   
            }else if(commands[0].equals("FLIP")){
                ba[input1-1].flip(input2);
            }else if(commands[0].equals("OR")){
                ba[input1-1].or(ba[input2-1]);
            }else if(commands[0].equals("XOR")){
                ba[input1-1].xor(ba[input2-1]);
            }
            System.out.println(numBitSet(ba[0]) + " "+ numBitSet(ba[1]));
        }
        scanner.close();
    }
    
    static int numBitSet(BitSet b1){
        int num=0;
        for(int i=0; i<b1.size();i++){
            num +=(b1.get(i)?1:0);
        }
        return num;
    }
}
