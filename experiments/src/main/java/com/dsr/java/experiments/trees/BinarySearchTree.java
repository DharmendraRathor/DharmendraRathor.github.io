package com.dsr.java.experiments.trees;

class Node {
	public int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
	}
}

public class BinarySearchTree {

	public void insert(int value, Node parent) {
		if (null != parent) {
			if (value < parent.data) {
				if (null != parent.left) {
					insert(value, parent.left);
				} else {
					Node n = new Node(value);
					parent.left = n;
				}
			} else {
				if (null != parent.right) {
					insert(value, parent.right);
				} else {
					Node n = new Node(value);
					parent.right = n;
				}

			}
		}
	}

	public static void main(String[] in) {
		BinarySearchTree tree = new BinarySearchTree();
		Node root = tree.createTree();
		System.out.println( " in - order ");
		tree.displayTreeInOrder(root);
		System.out.println( " pre - order ");
		tree.displayTreePreOrder(root);
		System.out.println( " post - order ");
		tree.displayTreePostOrder(root);
	}

	public Node createTree() {
		Node root = new Node(5);
		insert(3, root);
		insert(6, root);
		insert(2, root);
		insert(7, root);
		insert(1, root);
		insert(8, root);
		return root;
	}
	
	public void displayTreeInOrder(Node root) {
		if(null != root) {
			
			if(null != root.left) {
				displayTreeInOrder(root.left);
			}
			
			System.out.println( root.data );
			
			if(null != root.right) {
				displayTreeInOrder(root.right);
			}
		}
	}
	
	public void displayTreePreOrder(Node root) {
		if(null != root) {
			
			System.out.println( root.data );
			
			if(null != root.left) {
				displayTreePreOrder(root.left);
			}
			
			if(null != root.right) {
				displayTreePreOrder(root.right);
			}
		}
	}
	
	public void displayTreePostOrder(Node root) {
		if(null != root) {
			
			if(null != root.left) {
				displayTreePostOrder(root.left);
			}
			
			if(null != root.right) {
				displayTreePostOrder(root.right);
			}
			
			System.out.println( root.data );
		}
	}

}
