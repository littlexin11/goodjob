package com.nina.ds.bst;

public class SecondLargest {
	public static void main(String[] arg){
		
		Node root = createBST();
		Count count = new Count();
		getSecondLargest(root, count);
		
		
	}
	
	
    
	public static void getSecondLargest(Node node, Count count){
		
		//System.out.println("count="+count.c +" data="+ (node==null?"null":node.data));
		
		if(node == null || count.c >= 2)
			return;
		
		else {
			getSecondLargest(node.right, count);
			
			count.c++;
			
			if(count.c == 2) {
				System.out.println("second largest = "+ node.data);
				return;
			}
			
			getSecondLargest(node.left, count);
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
		root =  bst.insertNode(root, 21);
		root =  bst.insertNode(root, 18);
		root =  bst.insertNode(root, 13);
		root =  bst.insertNode(root, 16);
		root =  bst.insertNode(root, 15);
		root = bst.insertNode(root, 14);
		
		//System.out.println(root.toString());
		return root;
	}

}

class Count { 
    int c = 0; 
}
