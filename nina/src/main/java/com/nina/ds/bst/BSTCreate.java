package com.nina.ds.bst;

public class BSTCreate {
	public static void main(String[] arg){
		BST bst = new BST();
		Node root = null;
		//8, 3, 
		
		root = bst.insertNode(root, 8);
		root =  bst.insertNode(root, 3);
		
		root =  bst.insertNode(root, 6);
		
		root =  bst.insertNode(root, 10);
		root =  bst.insertNode(root, 18);
		root =  bst.insertNode(root, 13);
		root =  bst.insertNode(root, 16);
		root =  bst.insertNode(root, 15);
		root = bst.insertNode(root, 14);
		
		System.out.println(root.toString());
	}
}
