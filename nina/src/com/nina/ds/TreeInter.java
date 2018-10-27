package com.nina.ds;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

class SumInLeavesVisitor extends TreeVis {
	//The SumInLeavesVisitor implementation must 
	//return the sum of the values in the tree's leaves only.
	int sumInLeavesVisitor=0;
    public int getResult() {
      	//implement this
        return sumInLeavesVisitor;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    public int getResult() {
      	//implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
    }
}

class FancyVisitor extends TreeVis {
    public int getResult() {
      	//implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
    	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
    }
}

/**
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5
 */
public class TreeInter {

	
	public static Tree solve() {
		
        Scanner scanner = new Scanner(System.in);
        
        int numberOfNode = scanner.nextInt();
        
        List<TreeNode> nodeArray = new ArrayList<TreeNode>();
        List<Boolean> nodeOrLeafArray = new ArrayList<Boolean>();
        
        //skip the return
        scanner.nextLine();
        
        String[] values = scanner.nextLine().split(" ");
        String[] colors = scanner.nextLine().split(" ");
        
        //build up root
        
        
        int height = 0;
        
        TreeNode root = new TreeNode(Integer.valueOf(values[0])
    			, colors[0].equals("0")?Color.RED:Color.GREEN
    			, height);
        
        
        nodeArray.add(root);
        
        //0 red, 1 green
        int previewParentPosition=0;
        for(int i=1; i<numberOfNode; i++) {
        	
        	nodeOrLeafArray.add(previewParentPosition,true);
        	
        	int parentPosition = scanner.nextInt();
        	int selfPosition = scanner.nextInt();
        	
        	if(previewParentPosition !=parentPosition) {
        		height++;
        		previewParentPosition = parentPosition;
        		nodeOrLeafArray.add(parentPosition-1,true);
        	}
        	
        	//skip the return
            scanner.nextLine();
            
            
        	TreeNode node = new TreeNode(Integer.valueOf(values[i])
        			, colors[i].equals("0")?Color.RED:Color.GREEN
        			, height);
        	
        	
        	nodeArray.add(node);
        	
        	nodeArray.get(parentPosition-1).addChild(node);
        	
        }
        
        		
        
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