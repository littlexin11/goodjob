package com.nina.tree;

public class BalanceTreeCheck {

	public static void main(String[] arg){
		
		Node root = createBST();
		int d = getDepth(root);
		if(d ==-1)
			System.out.println("false" );
		else
			System.out.println("true depth=" + d);
	}
	
	public static int getDepth(Node node){
		if(node == null)
			return 0;
		else {
			int leftD = getDepth(node.left);
			
			if(leftD ==-1)
				return -1;
			
			int rightD = getDepth(node.right);
			
			if(rightD ==-1)
				return -1;
			
			if(Math.abs(leftD-rightD)>1)
				return -1;
			else
				return Math.max(leftD, rightD)+1;
		}
		
	}
	
	public static Node createBST(){
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
		return root;
	}

}
