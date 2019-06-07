package com.dsr.java.experiments.trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewBinaryTree {
	static Map<Integer, Node> map = new HashMap<>();
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		bottomView(root);

		
	}

	public static void bottomView(Node root) {
		
		Queue<Node> q = new LinkedList<>();
		root.hd = 0;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = q.remove();
			int hd = n.hd;
			map.put(hd, n);

			if (null != n.left) {
				n.left.hd = hd - 1;
				q.add(n.left);
			}

			if (null != n.right) {
				n.right.hd = hd + 1;
				q.add(n.right);
			}
		}
		
		
		map.keySet().parallelStream().sorted().forEach(x -> {
			System.out.print(map.get(x).data + " ");
		});
//		map.entrySet().forEach(x -> {
//			System.out.print(x.getValue().data + " ");
//		});


	}
}
