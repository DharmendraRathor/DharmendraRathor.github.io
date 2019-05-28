package com.dsr.java.experiments.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * Level order traversal and reverse level order traversal of binary tree. 
 * in o(n) complexity using queue and stack.
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
		levelOrderTraversal(n);
		reverseLevelOrderTraversal(n);

	}

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
