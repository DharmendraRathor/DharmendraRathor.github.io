package com.dsr.java.experiments.linklist;

import java.util.HashSet;
import java.util.Set;

import com.dsr.java.experiments.common.LinkNode;
/**
 * Find length of Loop
 * Given a linked list of size N. The task is to complete the function countNodesinLoop() that checks whether a given Linked List contains loop or not and if loop is present then return the count of nodes in loop or else return 0.
 * @author dharmendra
 *
 */
public class LoopLength {

	public static void main(String[] args) {
		LinkNode<Integer> head = new LinkNode<Integer>(1);
		head.next = new LinkNode<Integer>(2);
		head.next.next = new LinkNode<Integer>(3);
		head.next.next.next = new LinkNode<Integer>(4);
		head.next.next.next.next = new LinkNode<Integer>(5);

		/* Create a loop for testing */
		head.next.next.next.next.next = head.next;

		System.out.println(countNodesinLoop(head));
	}

	static int countNodesinLoop(LinkNode<Integer> head) {
		Set<LinkNode<Integer>> set = new HashSet<>();
		LinkNode<Integer> current = head;
		LinkNode<Integer> loopNode = null;
		while (null != current) {
			set.add(current);
			current = current.next;
			if (set.contains(current)) {
				loopNode = current;
				break;
			}
		}

		if(null == loopNode) {
			return 0;
		}
		
		current = loopNode;
		int count = 1;
		while (null != current) {
			current = current.next;

			if (current == loopNode) {
				break;
			}
			count++;

		}

		return count;

	}
}
