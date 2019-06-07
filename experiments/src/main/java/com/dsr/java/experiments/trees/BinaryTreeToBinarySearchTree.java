package com.dsr.java.experiments.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeToBinarySearchTree {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);

		List<Integer> nodes = new ArrayList<>();

		preorderSearch(n, nodes);

		nodes.stream().forEach(System.out::println);
		// List<Integer> sortedNodes =
		// nodes.stream().sorted().collect(Collectors.toList());
		Collections.sort(nodes);
		nodes.stream().forEach(x -> {
			System.out.print(x + " ");
		});
		System.out.println("");

		Node n1 = createBST(nodes, 0, nodes.size() - 1);

		List<Integer> nodes1 = new ArrayList<>();
		preorderSearch(n1, nodes1);
		nodes1.stream().forEach(x -> {
			System.out.print(x + " ");
		});

	}

	private static Node createBST(List<Integer> nodes, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		Node n = new Node(nodes.get(mid));
		n.left = createBST(nodes, start, mid - 1);
		n.right = createBST(nodes, mid + 1, end);
		return n;
	}

	private static void preorderSearch(Node n, List<Integer> nodes) {
		if (n == null) {
			return;
		}

		preorderSearch(n.left, nodes);
		nodes.add(n.data);
		preorderSearch(n.right, nodes);
	}
}
