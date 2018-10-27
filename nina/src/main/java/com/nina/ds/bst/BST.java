package com.nina.ds.bst;

public class BST {
	
	public Node createNode(int data){
		Node a=  new Node();
		a.data = data;
		a.left = null;
		a.right = null;
		return a;
	}
	
	
	
	
	public Node insertNode(Node node, int data){
		if(node == null) {
			return createNode(data);
		}else{
			if(node.data>data){
				Node lNode = node.left;
				node.left = insertNode(node.left, data);
			}else{
				node.right = insertNode(node.right, data);
			}
			return node;	
		}
	}
}
