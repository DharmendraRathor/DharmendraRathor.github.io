package com.dsr.java.experiments.linklist;

import com.dsr.java.experiments.common.LinkNode;

/**
 * 
 * @author dharmendra
 *
 */
public class ReverListInGroups {

	public static void main(String[] args) {

		LinkNode<Integer> head = new LinkNode<>(new Integer(0));

		LinkNode<Integer> newNode1 = new LinkNode<>(new Integer(1));
		head.setNextNode(newNode1);

		LinkNode<Integer> newNode2 = new LinkNode<>(new Integer(2));
		newNode1.setNextNode(newNode2);

		LinkNode<Integer> newNode3 = new LinkNode<>(new Integer(3));
		newNode2.setNextNode(newNode3);

		LinkNode<Integer> newNode4 = new LinkNode<>(new Integer(4));
		newNode3.setNextNode(newNode4);

		LinkNode<Integer> newNode5 = new LinkNode<>(new Integer(5));
		newNode4.setNextNode(newNode5);

		LinkNode<Integer> newNode6 = new LinkNode<>(new Integer(6));
		newNode5.setNextNode(newNode6);

		printList(head);
		LinkNode<Integer> Newhead = reverse(head, 3);
		printList(Newhead);

	}

	public static LinkNode<Integer> reverse(LinkNode<Integer> node, int k) {
		LinkNode<Integer> current = node;
		LinkNode<Integer> prev = null;
		LinkNode<Integer> next = null;
		int count = k;

		while (null != current && count > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count--;
		}

		if (next != null) {
			node.next = reverse(next, k);
		}

		return prev;
	}

	public static void printList(LinkNode<Integer> root) {
		LinkNode<Integer> current = root;
		System.out.println("\n Data  ");
		while (null != current) {
			System.out.print(current.data + " ");
			current = current.next;
		}

	}
}
