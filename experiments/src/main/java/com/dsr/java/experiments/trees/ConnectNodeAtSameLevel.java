package com.dsr.java.experiments.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Connect Nodes at Same Level
 * Given a binary tree, connect the nodes that are at same level.
 * 
 * @author dharmendra
 *
 */
public class ConnectNodeAtSameLevel {

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.left.left = new Node(4);
		n.right.right = new Node(5);
		
		levelOrderTraversal(n);
		printConnectedNodesPerLevel(n);
	}
	
	private static void levelOrderTraversal(Node n) {
		Queue<Node> queue = new LinkedList<>();

		if (null != n) {
			queue.add(n);
			while (!queue.isEmpty()) {
				int lenghtOfQueue = queue.size();
				Node prevNode = null;
				for (int i = 0; i < lenghtOfQueue; i++) {

					Node node = queue.poll();
					if(null != prevNode) {
						prevNode.rightNode = node;
					}
					prevNode = node;
					if (null != node) {
						//System.out.print(node.data + " ");
						queue.add(node.left);
						queue.add(node.right);
					}
				}
				//System.out.println("");
			}
		}

	}
	
	static void printConnectedNodesPerLevel(Node root)
	{
		if(root == null)
			return ;
		Node node = root;
		while(node != null)
		{
			System.out.print(node.data+" ");
			node = node.rightNode;
		}
		if(root.left != null)
			printConnectedNodesPerLevel(root.left);
		else 
			printConnectedNodesPerLevel(root.right);
		
	}
	
}
