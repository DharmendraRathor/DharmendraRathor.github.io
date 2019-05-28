package com.dsr.java.experiments.trees;

/**
 * Find height of binary tree. Complexity : O(n)
 * 
 * @author dharmendra
 *
 */
public class HeightOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("height " + height(root));
	}

	private static int height(Node root) {

		if (null == root) {
			return 0;
		}

		int leftHeight = height(root.left) + 1;
		int rightHeight = height(root.right) + 1;
		if (leftHeight == rightHeight) {
			return leftHeight;
		} else {
			return leftHeight > rightHeight ? leftHeight : rightHeight;
		}
	}
}
