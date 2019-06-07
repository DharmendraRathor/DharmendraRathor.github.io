package com.dsr.java.experiments.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * Level order traversal and reverse level order traversal of binary tree. in
 * o(n) complexity using queue and stack.
 * 
 * @author dharmendra
 *
 */
public class ReverseLevelOrderTreeTraversal {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		spiralLevelOrderTraversal(n);
		System.out.println(" ");
		levelOrderTraversalNoSpace(n);
		System.out.println(" ");
		levelOrderTraversal(n);
		reverseLevelOrderTraversal(n);

	}

	/**
	 * level order without queue.
	 * 
	 * @param n
	 */
	private static void levelOrderTraversalNoSpace(Node n) {
		boolean flag = true;
		for (int i = 1; i <= 3; i++) {
			printlevel(i, n, flag);
			flag = !flag;
		}
	}

	private static void printlevel(int i, Node n, boolean flag) {
		if (null == n) {
			return;
		}
		if (i == 1) {
			System.out.print(n.data + " ");
		} else {
			if (flag) {
				printlevel(i - 1, n.left, flag);
				printlevel(i - 1, n.right, flag);
			} else {
				printlevel(i - 1, n.right, flag);
				printlevel(i - 1, n.left, flag);
			}
		}

	}

	/**
	 * Level order with queue.
	 * 
	 * @param n
	 */
	private static void levelOrderTraversal(Node n) {
		Queue<Node> queue = new LinkedList<>();

		if (null != n) {
			queue.add(n);
			while (!queue.isEmpty()) {
				int lenghtOfQueue = queue.size();
				for (int i = 0; i < lenghtOfQueue; i++) {

					Node node = queue.poll();
					if (null != node) {
						System.out.print(node.data + " ");
						queue.add(node.left);
						queue.add(node.right);
					}
				}
				System.out.println("");
			}
		}

	}

	/**
	 * With two stack approach.
	 * 
	 * @param n
	 */
	private static void spiralLevelOrderTraversal(Node n) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		if (null != n) {
			s1.add(n);

			while (!s1.isEmpty() || !s2.isEmpty()) {
				while (!s1.isEmpty()) {
					Node node = s1.pop();
					if (null != node) {
						System.out.print(node.data + " ");

						s2.push(node.left);
						s2.push(node.right);
					}

				}
				// System.out.println("");

				while (!s2.isEmpty()) {
					Node node = s2.pop();
					if (null != node) {
						System.out.print(node.data + " ");

						s1.push(node.left);
						s1.push(node.right);
					}

				}
				// System.out.println("");

			}

		}

	}

	private static void reverseLevelOrderTraversal(Node n) {
		Queue<Node> queue = new LinkedList<>();

		if (null != n) {
			queue.add(n);
			Stack<Integer> stack = new Stack<>();
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				if (null != node) {
					stack.push(node.data);
					if (null != node.right)
						queue.add(node.right);

					if (null != node.left)
						queue.add(node.left);

				}
			}

			if (null != stack && !stack.isEmpty()) {
				while (!stack.isEmpty()) {
					System.out.print(stack.pop() + " ");
				}
			}
		}

	}

}
