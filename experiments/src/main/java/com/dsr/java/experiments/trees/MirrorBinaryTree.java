package com.dsr.java.experiments.trees;

public class MirrorBinaryTree {
	Node root;

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		inorder(root);
		
		Node node = mirror(root);
		System.out.println(" ");
		inorder(node);
	}
	
	
	private static Node mirror(Node node) {
		if(null == node)
			return null;
		
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		return node;
		
	}
	
	private static void inorder(Node node){
		if(null == node)
			return;
		
		 inorder(node.left);
		 System.out.print(node.data+" ");
		 inorder(node.right);
		
	}

}
