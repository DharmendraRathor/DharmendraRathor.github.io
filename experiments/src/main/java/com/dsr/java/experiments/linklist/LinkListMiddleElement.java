package com.dsr.java.experiments.linklist;

import com.dsr.java.experiments.common.LinkNode;

/**
 * Finding middle element in a linked list using two pointer approach.
 * @author dharmendra
 *
 */
public class LinkListMiddleElement {

	public static void main(String[] args) {
		
		//0->1->2->3->4->5
		LinkNode<Integer> head = new LinkNode(new Integer(0));
		
		LinkNode<Integer> newNode1 = new LinkNode(new Integer(1));
		head.setNextNode(newNode1);
		
		LinkNode<Integer> newNode2 = new LinkNode(new Integer(2));
		newNode1.setNextNode(newNode2);
		
		LinkNode<Integer> newNode3 = new LinkNode(new Integer(3));
		newNode2.setNextNode(newNode3);
		
		LinkNode<Integer> newNode4 = new LinkNode(new Integer(4));
		newNode3.setNextNode(newNode4);
		
		LinkNode<Integer> newNode5 = new LinkNode(new Integer(5));
		newNode4.setNextNode(newNode5);
		
		System.out.println(" Middle node data " + findMiddleNode(head));
	}

	private static Integer findMiddleNode(LinkNode<Integer> head) {

	    if(null == head){
	        return 0;
	    }
	    
	    LinkNode slow = head;
	    LinkNode fast = head.getNextNode();
	   
	   while(null != fast){
	       slow = slow.getNextNode();
	       
	       fast = fast.getNextNode();
	       if(null != fast){
	           fast = fast.getNextNode();
	       }
	       
	   }
	   
	   return Integer.parseInt(slow.getData().toString());

	}
	
}
