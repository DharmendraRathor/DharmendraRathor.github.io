package com.dsr.java.experiments.trees;

/**
 * Reference : example taken from geeksforgeeks
 * 
 * @author dharmendra
 *
 */
public class SubTreeCheck {

	public static void main(String args[]) {
		// TREE 1
		/*
		 * Construct the following tree 26 / \ 10 3 / \ \ 4 6 3 \ 30
		 */

		Node root1 = new Node(26);
		root1.right = new Node(3);
		root1.right.right = new Node(3);
		root1.left = new Node(10);
		root1.left.left = new Node(4);
		root1.left.left.right = new Node(30);
		root1.left.right = new Node(6);

		// TREE 2
		/*
		 * Construct the following tree 10 / \ 4 6 \ 30
		 */

		Node root2 = new Node(10);
		root2.right = new Node(6);
		root2.left = new Node(4);
		root2.left.right = new Node(30);

		if (isSubtree(root1, root2))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}

	/**
	 * Pre-order traversal of main tree.
	 * 
	 * @param main
	 * @param sub
	 * @return
	 */
	private static boolean isSubtree(Node main, Node sub) {

		if (null == sub) {
			return true;
		}

		if (null == main) {
			return false;
		}

		if (isIdentical(main, sub)) {
			return true;
		}

		if (isSubtree(main.left, sub)) {
			return true;
		}

		if (isSubtree(main.right, sub)) {
			return true;
		}

		return false;
	}

	private static boolean isIdentical(Node main, Node sub) {
		if (null == main && null == sub) {
			return true;
		}

		if (null == main || null == sub) {
			return false;
		}

		if ((main.data == sub.data) && isIdentical(main.left, sub.left) && isIdentical(main.right, sub.right)) {
			return true;
		}

		return false;
	}
}
