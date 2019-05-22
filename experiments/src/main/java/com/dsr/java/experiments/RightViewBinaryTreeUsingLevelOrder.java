package com.dsr.java.experiments;

import java.util.LinkedList;
import java.util.List;

public class RightViewBinaryTreeUsingLevelOrder {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		rightView(root);

	}

	private static void rightView(Node node) {

		List<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int k = 1;
			while (k <= size) {

				Node element = queue.get(0);

				if (k == size) {
					System.out.print(element.data + " ");
				}

				if (null != element.left) {
					queue.add(element.left);
				}

				if (null != element.right) {
					queue.add(element.right);
				}

				queue.remove(queue.get(0));
				k++;
			}

		}

	}

}
