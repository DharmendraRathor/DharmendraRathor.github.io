package com.dsr.java.experiments.linklist;

import java.util.HashSet;
import java.util.Set;

import com.dsr.java.experiments.common.LinkNode;

/**
 * 
 * Remove duplicate element from Linked List Given a singly linked list
 * consisting of N nodes. The task is to remove duplicates (nodes with duplicate
 * values) from the given list (if exists).
 * 
 * Time Complexity O(n)
 * 
 * Note : this is using extra set ,if list is sorted we can avoid using extra stack.
 * 
 * @author dharmendra
 *
 */
public class DuplicateInLinkList {

	static Set<Integer> uniqueElements = new HashSet<>();

	public static void main(String[] args) {

		LinkNode<Integer> head = new LinkNode<>(new Integer(0));

		LinkNode<Integer> newNode1 = new LinkNode<>(new Integer(1));
		head.setNextNode(newNode1);

		LinkNode<Integer> newNode2 = new LinkNode<>(new Integer(2));
		newNode1.setNextNode(newNode2);

		LinkNode<Integer> newNode3 = new LinkNode<>(new Integer(3));
		newNode2.setNextNode(newNode3);

		LinkNode<Integer> newNode4 = new LinkNode<>(new Integer(2));
		newNode3.setNextNode(newNode4);

		LinkNode<Integer> newNode5 = new LinkNode<>(new Integer(5));
		newNode4.setNextNode(newNode5);
		
		printList(head);
		
		LinkNode<Integer> NewHead = removeDuplicates(head);
		
		printList(NewHead);
	
		
	}

	public static LinkNode<Integer> removeDuplicates(LinkNode<Integer> root) {
		LinkNode<Integer> current = root;
		LinkNode<Integer> previous = null;
		while (null != current) {
			if (uniqueElements.contains(current.data)) {
				previous.next = current.next;
			} else {
				uniqueElements.add(current.data);
				previous = current;
			}

			current = current.next;
		}
		return root;
	}
	
	public static void printList(LinkNode<Integer> root) {
		LinkNode<Integer> current = root;
		System.out.println( "\n Data  ");
		while(null != current) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		
	}
}
