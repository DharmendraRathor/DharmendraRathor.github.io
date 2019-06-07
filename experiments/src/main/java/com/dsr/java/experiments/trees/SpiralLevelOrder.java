package com.dsr.java.experiments.trees;

import java.util.Stack;

/**
 * Level order traversal in spiral form
 * Write a function to print spiral order traversal of a tree.
 * @author dharmendra
 * Time Complexity : o(n) , space 2 o(n)
 *
 */
public class SpiralLevelOrder {
	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		spiralLevelOrderTraversal(n);
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
				System.out.println("");

				while (!s2.isEmpty()) {
					Node node = s2.pop();
					if (null != node) {
						System.out.print(node.data + " ");

						s1.push(node.left);
						s1.push(node.right);
					}

				}
				System.out.println("");

			}

		}

	}

}
