package com.nina.ds.tree.java7;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
 */
class SumInLeavesVisitor extends TreeVis {
	//The SumInLeavesVisitor implementation must 
	//return the sum of the values in the tree's leaves only.
	int result=0;
    public int getResult() {
      	//implement this
        return result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    	//not doing anything
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
    	result+=leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	int result=1;
	
    public int getResult() {
      	//implement this
        return result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    	if(Color.RED.equals(node.getColor()))
    		result = result*node.getValue();
    	
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
    	if(Color.RED.equals(leaf.getColor()))
    		result = result*leaf.getValue();
    	
    }
}

/*The FancyVisitor implementation must return the absolute difference between 
 * the sum of values stored in the tree's non-leaf nodes at even depth 
 * and the sum of values stored in the tree's green leaf nodes. Recall that zero is an even number.
*/
class FancyVisitor extends TreeVis {
	int sumEvenNotLeaf=0;
	int sumLeafGreen=0;
	
    public int getResult() {
      	//implement this
        return Math.abs(sumEvenNotLeaf-sumLeafGreen);
    }

    public void visitNode(TreeNode node) {
    	if(node.getDepth()%2==0)
    		sumEvenNotLeaf+=node.getValue();
    	
    	
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(Color.GREEN.equals(leaf.getColor()))
    		sumLeafGreen+=leaf.getValue();
    	
    	
    }
}


public class TreeInterJava7 {

	
	public static Tree solve() {
		
        Scanner scanner = new Scanner(System.in);
        
        int numberOfNode = scanner.nextInt();
        
        List<Tree> treeArray = new ArrayList<Tree>();
        
        //skip the return
        scanner.nextLine();
        
        String[] values = scanner.nextLine().split(" ");
        String[] colors = scanner.nextLine().split(" ");
        boolean[] parentFlags = new boolean[numberOfNode];
        
        //init leaf flag
        for(int i=0; i<numberOfNode; i++) {  
        	parentFlags[i] = false;
        }
        
        
        
        //read data
        ArrayList<Integer[]> positionList = new ArrayList<Integer[]>();
        
        for(int i=0; i<numberOfNode; i++){
        	
        	try {
        	System.out.println("i="+i);
        	
        	FutureTask<String> task = new FutureTask<>(() -> {
                return scanner.nextLine();
            });

            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
        	String line;
			
				line = task.get(5, TimeUnit.SECONDS);
			

        	
        	String[] positionS = line.split(" ");
        	int parentPosition = Integer.valueOf(positionS[0])-1;
        	int selfPosition = Integer.valueOf(positionS[1])-1;
        	Integer[] postion = {parentPosition, selfPosition};
        	positionList.add(postion);
        	parentFlags[parentPosition] = true;
        	
        	} catch (InterruptedException | ExecutionException | TimeoutException e) {
				break;
			}
        }
        
        
        //build up root
        Tree root = null;
        
        if(numberOfNode>1){
        	root = new TreeNode(Integer.valueOf(values[0])
    			, colors[0].equals("0")?Color.RED:Color.GREEN
    			, 0);
        
        }else{
        	root = new TreeLeaf(Integer.valueOf(values[0])
        			, colors[0].equals("0")?Color.RED:Color.GREEN
        			, 0);      
        }
        
        treeArray.add(root);
        
        //0 red, 1 green
        
        for(int i=0; i<positionList.size(); i++) {
        	Integer[] postion = positionList.get(i);
        	
        	Tree node = null;
        	
        	if(!parentFlags[postion[1]]) {
        		node = new TreeLeaf(Integer.valueOf(values[postion[1]])
            			, colors[postion[1]].equals("0")?Color.RED:Color.GREEN
                    			, treeArray.get(postion[0]).getDepth()+1);
        	}else{
        		node = new TreeNode(Integer.valueOf(values[postion[1]])
        			, colors[postion[1]].equals("0")?Color.RED:Color.GREEN
        			, treeArray.get(postion[0]).getDepth()+1);
        	}
        	
        	treeArray.add(node);
            
        	
        	((TreeNode)treeArray.get(postion[0])).addChild(node);
        	
        } 		
        scanner.close();
		return root;
		
    }

    public static void main(String[] args) {
      	Tree root = solve();
      	
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}




enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

