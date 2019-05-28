package com.dsr.java.experiments.linklist;

import com.dsr.java.experiments.common.LinkNode;

/**
 * Nth node from end of linked list. Given a linked list consisting of L nodes
 * and given a number N. The task is to find the Nth node from the end of the
 * linked list.	
 * 
 * Time Complexity = O(n)
 * 
 * @author dharmendra
 *
 */

public class NthElementFromEnd {

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

		System.out.println("element value is " + getNthFromLast(head, 2));

	}

	// Function to find the nth node from end in the linked list
	// head: head of the linked list
	// n: nth node from end to find
	public static Integer getNthFromLast(LinkNode<Integer> head, int n) {
		if (null == head || n < 0) {
			return -1;
		}
		LinkNode<Integer> originalHead = head;
		int length = 0;
		while (null != head) {
			length++;
			head = head.getNextNode();
		}

		int correctPosition = length - n;

		length = 0;
		while (null != originalHead) {
			if (length == correctPosition) {
				return (Integer) originalHead.getData();
			}
			length++;
			originalHead = originalHead.getNextNode();

		}

		return -1;
	}
}
